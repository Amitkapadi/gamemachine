module GameMachine
    class ChatManager < Actor


    aspect %w(ChatMessage Player ClientConnection)
    aspect %w(JoinChat Player ClientConnection)
    aspect %w(LeaveChat Player ClientConnection)

    def post_init(*args)
      @chat_actors = {}
    end

    def on_receive(message)
      if message.is_a?(Disconnected)
        destroy_child(message)
      else
        unless @chat_actors.has_key?(message.player.id)
          create_child(message.player.id)
          PlayerRegistry.register_observer(message.player.id,ActorRef.new(get_self))
        end
        forward_chat_request(message.player.id,message)
      end
    end

    private

    def destroy_child(message)
      player_id = message.player_id
      if @chat_actors.has_key?(player_id)
        forward_chat_request(player_id,JavaLib::PoisonPill.get_instance)
        @chat_actors.delete(player_id)
        GameMachine.logger.debug "Chat child for #{player_id} killed"
      else
        GameMachine.logger.info "chat actor for player_id #{player_id} not found"
      end
    end

    def forward_chat_request(player_id,message)
      @chat_actors[player_id].tell(message,nil)
    end

    def child_name(player_id)
      "chat#{player_id}"
    end

    def create_child(player_id)
      name = child_name(player_id)
      builder = ActorBuilder.new(Systems::Chat,player_id)
      child = builder.with_parent(context).with_name(name).start
      @chat_actors[player_id] = ActorRef.new(child,Systems::Chat.name)
      GameMachine.logger.warn "Chat child for #{player_id} created"
    end
  end
end
