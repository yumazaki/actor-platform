/*
 * Copyright (C) 2015 Actor LLC. <https://actor.im>
 */

package im.actor.model.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.model.droidkit.bser.Bser;
import im.actor.model.droidkit.bser.BserParser;
import im.actor.model.droidkit.bser.BserObject;
import im.actor.model.droidkit.bser.BserValues;
import im.actor.model.droidkit.bser.BserWriter;
import im.actor.model.droidkit.bser.DataInput;
import im.actor.model.droidkit.bser.DataOutput;
import static im.actor.model.droidkit.bser.Utils.*;
import java.io.IOException;
import im.actor.model.network.parser.*;
import java.util.List;
import java.util.ArrayList;
import im.actor.model.api.*;

public class RequestGetContacts extends Request<ResponseGetContacts> {

    public static final int HEADER = 0x57;
    public static RequestGetContacts fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestGetContacts(), data);
    }

    private String contactsHash;

    public RequestGetContacts(String contactsHash) {
        this.contactsHash = contactsHash;
    }

    public RequestGetContacts() {

    }

    public String getContactsHash() {
        return this.contactsHash;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.contactsHash = values.getString(1);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.contactsHash == null) {
            throw new IOException();
        }
        writer.writeString(1, this.contactsHash);
    }

    @Override
    public String toString() {
        String res = "rpc GetContacts{";
        res += "contactsHash=" + this.contactsHash;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
