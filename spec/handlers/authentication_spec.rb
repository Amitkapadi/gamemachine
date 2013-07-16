require 'spec_helper'

module GameMachine
  module Handlers
    
    describe Authentication do

      let(:handler) {double('Handler', :tell => true)}
      let(:actor_ref) {double('ActorRef', :ask => true)}
      let(:player) {Player.new.set_id('player1').set_authtoken('authorized')}
      let(:client_connection) do
        ClientConnection.new.set_id(player.id).set_gateway('blah')
      end

      let(:message) do
        ClientMessage.new.set_player(player).
          set_client_connection(client_connection)
      end

      let(:machine) {AuthenticationMachine.new(message)}

      subject do
        props = JavaLib::Props.new(Authentication);
        ref = JavaLib::TestActorRef.create(Akka.instance.actor_system, props, Authentication.name);
        ref.underlying_actor.post_init
        ref.underlying_actor
      end


      describe "authenticating a player" do

        before(:each) do
          Handlers::Game.stub(:find).and_return(handler)
          PlayerRegistry.stub(:find).and_return(actor_ref)
        end

        context "player is authenticated" do
          it "authenticates player with valid authtoken" do
            subject.on_receive(message)
            expect(subject.state_machine.authenticated?).to be_true
          end

          it "set player.authenticated to true when authenticated " do
            subject.on_receive(message)
            expect(subject.state_machine.message.player.authenticated).to be_true
          end

          it "registers player after authentication" do
            expect(actor_ref).to receive(:ask)
            subject.on_receive(message)
          end

          it "forwards message to next handler after authentication" do
            expect(handler).to receive(:tell)
            subject.on_receive(message)
          end
        end

        context "player is not authenticated" do
          it "does not authenticate player with invalid authtoken" do
            player.set_authtoken('badtoken')
            subject.on_receive(message)
            expect(subject.state_machine.authenticated?).to_not be_true
          end
        end


      end

    end
  end
end
