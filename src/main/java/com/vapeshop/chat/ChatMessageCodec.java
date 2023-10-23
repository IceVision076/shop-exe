package com.vapeshop.chat;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.websocket.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ChatMessageCodec
        implements Encoder.BinaryStream<ChatMessage>,
        Decoder.BinaryStream<ChatMessage>
{

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.findAndRegisterModules();
        MAPPER.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
    }

    @Override
    public void encode(ChatMessage chatMessage, OutputStream outputStream)
            throws EncodeException, IOException
    {
        try
        {
            System.out.println("Đang mã hoá "+chatMessage);
            ChatMessageCodec.MAPPER.writeValue(outputStream, chatMessage);
        }
        catch(JsonGenerationException | JsonMappingException e)
        {
            throw new EncodeException(chatMessage, e.getMessage(), e);
        }
    }

    @Override
    public ChatMessage decode(InputStream inputStream)
            throws DecodeException, IOException
    {
        try
        {
//            String
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String string = bufferedReader.readLine();
            System.out.println("Đang giải mã "+string);
            return ChatMessageCodec.MAPPER.readValue(
                    string, ChatMessage.class
            );
        }
        catch(JsonParseException | JsonMappingException e)
        {
            throw new DecodeException((ByteBuffer)null, e.getMessage(), e);
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) { }

    @Override
    public void destroy() { }
}
