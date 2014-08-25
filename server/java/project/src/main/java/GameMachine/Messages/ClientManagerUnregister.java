
package GameMachine.Messages;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dyuproject.protostuff.ByteString;
import com.dyuproject.protostuff.GraphIOUtil;
import com.dyuproject.protostuff.Input;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.Output;
import com.dyuproject.protostuff.ProtobufOutput;

import java.io.ByteArrayOutputStream;
import com.dyuproject.protostuff.JsonIOUtil;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import GameMachine.Messages.Entity;
import com.game_machine.core.LocalLinkedBuffer;

import org.javalite.activejdbc.Model;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.UninitializedMessageException;

public final class ClientManagerUnregister  implements Externalizable, Message<ClientManagerUnregister>, Schema<ClientManagerUnregister>

{

    public static Schema<ClientManagerUnregister> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static ClientManagerUnregister getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final ClientManagerUnregister DEFAULT_INSTANCE = new ClientManagerUnregister();

		public String registerType;

		public String name;

    public ClientManagerUnregister()
    {
        
    }

	public static void clearModel(Model model) {

    	model.set("client_manager_unregister_register_type",null);

    	model.set("client_manager_unregister_name",null);
    	
    }
    
	public void toModel(Model model, String playerId) {

    	if (registerType != null) {
    		model.setString("client_manager_unregister_register_type",registerType);
    	}

    	if (name != null) {
    		model.setString("client_manager_unregister_name",name);
    	}

    	if (playerId != null) {
    		model.set("player_id",playerId);
    	}
    }
    
	public static ClientManagerUnregister fromModel(Model model) {
		boolean hasFields = false;
    	ClientManagerUnregister message = new ClientManagerUnregister();

    	String registerTypeField = model.getString("client_manager_unregister_register_type");
    	if (registerTypeField != null) {
    		message.setRegisterType(registerTypeField);
    		hasFields = true;
    	}

    	String nameField = model.getString("client_manager_unregister_name");
    	if (nameField != null) {
    		message.setName(nameField);
    		hasFields = true;
    	}
    	
    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }

	public String getRegisterType() {
		return registerType;
	}
	
	public ClientManagerUnregister setRegisterType(String registerType) {
		this.registerType = registerType;
		return this;
	}
	
	public Boolean hasRegisterType()  {
        return registerType == null ? false : true;
    }

	public String getName() {
		return name;
	}
	
	public ClientManagerUnregister setName(String name) {
		this.name = name;
		return this;
	}
	
	public Boolean hasName()  {
        return name == null ? false : true;
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

    public Schema<ClientManagerUnregister> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public ClientManagerUnregister newMessage()
    {
        return new ClientManagerUnregister();
    }

    public Class<ClientManagerUnregister> typeClass()
    {
        return ClientManagerUnregister.class;
    }

    public String messageName()
    {
        return ClientManagerUnregister.class.getSimpleName();
    }

    public String messageFullName()
    {
        return ClientManagerUnregister.class.getName();
    }

    public boolean isInitialized(ClientManagerUnregister message)
    {
        return true;
    }

    public void mergeFrom(Input input, ClientManagerUnregister message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                
            	case 1:

                	message.registerType = input.readString();
                	break;

            	case 2:

                	message.name = input.readString();
                	break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }

    public void writeTo(Output output, ClientManagerUnregister message) throws IOException
    {

    	if(message.registerType != null)
            output.writeString(1, message.registerType, false);

    	if(message.name != null)
            output.writeString(2, message.name, false);

    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	
        	case 1: return "registerType";
        	
        	case 2: return "name";
        	
            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
    	
    	__fieldMap.put("registerType", 1);
    	
    	__fieldMap.put("name", 2);
    	
    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = ClientManagerUnregister.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static ClientManagerUnregister parseFrom(byte[] bytes) {
	ClientManagerUnregister message = new ClientManagerUnregister();
	ProtobufIOUtil.mergeFrom(bytes, message, RuntimeSchema.getSchema(ClientManagerUnregister.class));
	return message;
}

public ClientManagerUnregister clone() {
	byte[] bytes = this.toByteArray();
	ClientManagerUnregister clientManagerUnregister = ClientManagerUnregister.parseFrom(bytes);
	return clientManagerUnregister;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public byte[] toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, ClientManagerUnregister.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	return out.toByteArray();
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<ClientManagerUnregister> schema = RuntimeSchema.getSchema(ClientManagerUnregister.class);
    
	final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ProtobufOutput output = new ProtobufOutput(buffer);
    try
    {
    	schema.writeTo(output, this);
        final int size = output.getSize();
        ProtobufOutput.writeRawVarInt32Bytes(out, size);
        final int msgSize = LinkedBuffer.writeTo(out, buffer);
        assert size == msgSize;
        
        buffer.clear();
        return out.toByteArray();
    }
    catch (IOException e)
    {
        throw new RuntimeException("Serializing to a byte array threw an IOException " + 
                "(should never happen).", e);
    }
 
}

public byte[] toProtobuf() {
	LinkedBuffer buffer = LocalLinkedBuffer.get();
	byte[] bytes = null;

	try {
		bytes = ProtobufIOUtil.toByteArray(this, RuntimeSchema.getSchema(ClientManagerUnregister.class), buffer);
		buffer.clear();
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bytes;
}

public ByteBuf toByteBuf() {
	ByteBuf bb = Unpooled.buffer(512, 2048);
	LinkedBuffer buffer = LinkedBuffer.use(bb.array());

	try {
		ProtobufIOUtil.writeTo(buffer, this, RuntimeSchema.getSchema(ClientManagerUnregister.class));
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}
