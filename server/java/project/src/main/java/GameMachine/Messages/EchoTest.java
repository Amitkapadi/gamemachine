
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

public final class EchoTest  implements Externalizable, Message<EchoTest>, Schema<EchoTest>

{

    public static Schema<EchoTest> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static EchoTest getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final EchoTest DEFAULT_INSTANCE = new EchoTest();

		public String message;

    public EchoTest()
    {
        
    }

	public static void clearModel(Model model) {

    	model.set("echo_test_message",null);
    	
    }
    
	public void toModel(Model model, String playerId) {

    	if (message != null) {
    		model.setString("echo_test_message",message);
    	}

    	if (playerId != null) {
    		model.set("player_id",playerId);
    	}
    }
    
	public static EchoTest fromModel(Model model) {
		boolean hasFields = false;
    	EchoTest message = new EchoTest();

    	String messageField = model.getString("echo_test_message");
    	if (messageField != null) {
    		message.setMessage(messageField);
    		hasFields = true;
    	}
    	
    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }

	public String getMessage() {
		return message;
	}
	
	public EchoTest setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public Boolean hasMessage()  {
        return message == null ? false : true;
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

    public Schema<EchoTest> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public EchoTest newMessage()
    {
        return new EchoTest();
    }

    public Class<EchoTest> typeClass()
    {
        return EchoTest.class;
    }

    public String messageName()
    {
        return EchoTest.class.getSimpleName();
    }

    public String messageFullName()
    {
        return EchoTest.class.getName();
    }

    public boolean isInitialized(EchoTest message)
    {
        return true;
    }

    public void mergeFrom(Input input, EchoTest message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                
            	case 1:

                	message.message = input.readString();
                	break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }

    public void writeTo(Output output, EchoTest message) throws IOException
    {

    	if(message.message == null)
            throw new UninitializedMessageException(message);

    	if(message.message != null)
            output.writeString(1, message.message, false);

    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	
        	case 1: return "message";
        	
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
    	
    	__fieldMap.put("message", 1);
    	
    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = EchoTest.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static EchoTest parseFrom(byte[] bytes) {
	EchoTest message = new EchoTest();
	ProtobufIOUtil.mergeFrom(bytes, message, RuntimeSchema.getSchema(EchoTest.class));
	return message;
}

public EchoTest clone() {
	byte[] bytes = this.toByteArray();
	EchoTest echoTest = EchoTest.parseFrom(bytes);
	return echoTest;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public byte[] toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, EchoTest.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	return out.toByteArray();
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<EchoTest> schema = RuntimeSchema.getSchema(EchoTest.class);
    
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
		bytes = ProtobufIOUtil.toByteArray(this, RuntimeSchema.getSchema(EchoTest.class), buffer);
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
		ProtobufIOUtil.writeTo(buffer, this, RuntimeSchema.getSchema(EchoTest.class));
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}
