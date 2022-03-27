package com.daniel.mysuperchat.utils;

import com.daniel.mysuperchat.domain.Message;

import java.io.*;

public class SerialUtil {

    public static byte[] serialize(Message message) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream stream = new ObjectOutputStream(baos)) {
                stream.writeObject(message);
            }
            return baos.toByteArray();
        }
    }

    public static Message deserialize(byte[] source) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(source)) {
            try (ObjectInputStream stream = new ObjectInputStream(bais)) {
                return (Message) stream.readObject();
            }
        }

    }


}
