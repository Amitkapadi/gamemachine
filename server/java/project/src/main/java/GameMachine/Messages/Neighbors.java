
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

public final class Neighbors  implements Externalizable, Message<Neighbors>, Schema<Neighbors>

{

    public static Schema<Neighbors> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static Neighbors getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final Neighbors DEFAULT_INSTANCE = new Neighbors();

    public List<TrackData> trackData;

    public Neighbors()
    {
        
    }

	public static void clearModel(Model model) {

    }
    
	public void toModel(Model model, String playerId) {

    	if (playerId != null) {
    		model.set("player_id",playerId);
    	}
    }
    
	public static Neighbors fromModel(Model model) {
		boolean hasFields = false;
    	Neighbors message = new Neighbors();

    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }

	public List<TrackData> getTrackDataList() {
		return trackData;
	}

	public Neighbors setTrackDataList(List<TrackData> trackData) {
		this.trackData = trackData;
		return this;
	}

	public TrackData getTrackData(int index)  {
        return trackData == null ? null : trackData.get(index);
    }

    public int getTrackDataCount()  {
        return trackData == null ? 0 : trackData.size();
    }

    public Neighbors addTrackData(TrackData trackData)  {
        if(this.trackData == null)
            this.trackData = new ArrayList<TrackData>();
        this.trackData.add(trackData);
        return this;
    }

    public Neighbors removeTrackDataBySpeed(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.speed.equals(obj.speed)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataByVelocity(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.velocity.equals(obj.velocity)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataByJson(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.json.equals(obj.json)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataById(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.id.equals(obj.id)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataByX(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.x.equals(obj.x)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataByY(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.y.equals(obj.y)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataByZ(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.z.equals(obj.z)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataByEntityType(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.entityType.equals(obj.entityType)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataByNeighborEntityType(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.neighborEntityType.equals(obj.neighborEntityType)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Neighbors removeTrackDataByAction(TrackData trackData)  {
    	if(this.trackData == null)
           return this;
            
       	Iterator<TrackData> itr = this.trackData.iterator();
       	while (itr.hasNext()) {
    	TrackData obj = itr.next();

    		if (trackData.action.equals(obj.action)) {
    	
      			itr.remove();
    		}
		}
        return this;
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

    public Schema<Neighbors> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public Neighbors newMessage()
    {
        return new Neighbors();
    }

    public Class<Neighbors> typeClass()
    {
        return Neighbors.class;
    }

    public String messageName()
    {
        return Neighbors.class.getSimpleName();
    }

    public String messageFullName()
    {
        return Neighbors.class.getName();
    }

    public boolean isInitialized(Neighbors message)
    {
        return true;
    }

    public void mergeFrom(Input input, Neighbors message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                
            	case 1:
            	
            		if(message.trackData == null)
                        message.trackData = new ArrayList<TrackData>();
                    
                    message.trackData.add(input.mergeObject(null, TrackData.getSchema()));
                    
                    break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }

    public void writeTo(Output output, Neighbors message) throws IOException
    {

    	if(message.trackData != null)
        {
            for(TrackData trackData : message.trackData)
            {
                if(trackData != null) {
                   	
    				output.writeObject(1, trackData, TrackData.getSchema(), true);
    				
    			}
            }
        }

    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	
        	case 1: return "trackData";
        	
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
    	
    	__fieldMap.put("trackData", 1);
    	
    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = Neighbors.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static Neighbors parseFrom(byte[] bytes) {
	Neighbors message = new Neighbors();
	ProtobufIOUtil.mergeFrom(bytes, message, RuntimeSchema.getSchema(Neighbors.class));
	return message;
}

public Neighbors clone() {
	byte[] bytes = this.toByteArray();
	Neighbors neighbors = Neighbors.parseFrom(bytes);
	return neighbors;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public byte[] toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, Neighbors.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	return out.toByteArray();
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<Neighbors> schema = RuntimeSchema.getSchema(Neighbors.class);
    
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
		bytes = ProtobufIOUtil.toByteArray(this, RuntimeSchema.getSchema(Neighbors.class), buffer);
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
		ProtobufIOUtil.writeTo(buffer, this, RuntimeSchema.getSchema(Neighbors.class));
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}
