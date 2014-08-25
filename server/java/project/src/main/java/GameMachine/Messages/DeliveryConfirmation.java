
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

public final class DeliveryConfirmation  implements Externalizable, Message<DeliveryConfirmation>, Schema<DeliveryConfirmation>

{

    public static Schema<DeliveryConfirmation> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static DeliveryConfirmation getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final DeliveryConfirmation DEFAULT_INSTANCE = new DeliveryConfirmation();

		public String messageId;

    public DeliveryConfirmation()
    {
        
    }

	public static void clearModel(Model model) {

    	model.set("delivery_confirmation_message_id",null);
    	
    }
    
	public void toModel(Model model, String playerId) {

    	if (messageId != null) {
    		model.setString("delivery_confirmation_message_id",messageId);
    	}

    	if (playerId != null) {
    		model.set("player_id",playerId);
    	}
    }
    
	public static DeliveryConfirmation fromModel(Model model) {
		boolean hasFields = false;
    	DeliveryConfirmation message = new DeliveryConfirmation();

    	String messageIdField = model.getString("delivery_confirmation_message_id");
    	if (messageIdField != null) {
    		message.setMessageId(messageIdField);
    		hasFields = true;
    	}
    	
    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }

	public String getMessageId() {
		return messageId;
	}
	
	public DeliveryConfirmation setMessageId(String messageId) {
		this.messageId = messageId;
		return this;
	}
	
	public Boolean hasMessageId()  {
        return messageId == null ? false : true;
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

    public Schema<DeliveryConfirmation> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public DeliveryConfirmation newMessage()
    {
        return new DeliveryConfirmation();
    }

    public Class<DeliveryConfirmation> typeClass()
    {
        return DeliveryConfirmation.class;
    }

    public String messageName()
    {
        return DeliveryConfirmation.class.getSimpleName();
    }

    public String messageFullName()
    {
        return DeliveryConfirmation.class.getName();
    }

    public boolean isInitialized(DeliveryConfirmation message)
    {
        return true;
    }

    public void mergeFrom(Input input, DeliveryConfirmation message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                
            	case 1:

                	message.messageId = input.readString();
                	break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }

    public void writeTo(Output output, DeliveryConfirmation message) throws IOException
    {

    	if(message.messageId == null)
            throw new UninitializedMessageException(message);

    	if(message.messageId != null)
            output.writeString(1, message.messageId, false);

    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	
        	case 1: return "messageId";
        	
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
    	
    	__fieldMap.put("messageId", 1);
    	
    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = DeliveryConfirmation.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static DeliveryConfirmation parseFrom(byte[] bytes) {
	DeliveryConfirmation message = new DeliveryConfirmation();
	ProtobufIOUtil.mergeFrom(bytes, message, RuntimeSchema.getSchema(DeliveryConfirmation.class));
	return message;
}

public DeliveryConfirmation clone() {
	byte[] bytes = this.toByteArray();
	DeliveryConfirmation deliveryConfirmation = DeliveryConfirmation.parseFrom(bytes);
	return deliveryConfirmation;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public byte[] toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, DeliveryConfirmation.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	return out.toByteArray();
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<DeliveryConfirmation> schema = RuntimeSchema.getSchema(DeliveryConfirmation.class);
    
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
		bytes = ProtobufIOUtil.toByteArray(this, RuntimeSchema.getSchema(DeliveryConfirmation.class), buffer);
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
		ProtobufIOUtil.writeTo(buffer, this, RuntimeSchema.getSchema(DeliveryConfirmation.class));
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}
