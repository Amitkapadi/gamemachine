// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from messages.proto

package com.game_machine.proto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.dyuproject.protostuff.GraphIOUtil;
import com.dyuproject.protostuff.Input;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.Output;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.UninitializedMessageException;

public final class ClientConnection implements Externalizable, Message<ClientConnection>, Schema<ClientConnection>
{

    public static Schema<ClientConnection> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static ClientConnection getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final ClientConnection DEFAULT_INSTANCE = new ClientConnection();

    
    private String id;

    public ClientConnection()
    {
        
    }

    public ClientConnection(
        String id
    )
    {
        this.id = id;
    }

    // getters and setters

    // id

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<ClientConnection> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public ClientConnection newMessage()
    {
        return new ClientConnection();
    }

    public Class<ClientConnection> typeClass()
    {
        return ClientConnection.class;
    }

    public String messageName()
    {
        return ClientConnection.class.getSimpleName();
    }

    public String messageFullName()
    {
        return ClientConnection.class.getName();
    }

    public boolean isInitialized(ClientConnection message)
    {
        return 
            message.id != null;
    }

    public void mergeFrom(Input input, ClientConnection message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                case 1:
                    message.id = input.readString();
                    break;
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, ClientConnection message) throws IOException
    {
        if(message.id == null)
            throw new UninitializedMessageException(message);
        output.writeString(1, message.id, false);
    }

    public String getFieldName(int number)
    {
        return Integer.toString(number);
    }

    public int getFieldNumber(String name)
    {
        return Integer.parseInt(name);
    }
    
}
