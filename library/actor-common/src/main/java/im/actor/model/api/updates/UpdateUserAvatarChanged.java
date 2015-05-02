/*
 * Copyright (C) 2015 Actor LLC. <https://actor.im>
 */

package im.actor.model.api.updates;
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

public class UpdateUserAvatarChanged extends Update {

    public static final int HEADER = 0x10;
    public static UpdateUserAvatarChanged fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdateUserAvatarChanged(), data);
    }

    private int uid;
    private Avatar avatar;

    public UpdateUserAvatarChanged(int uid, Avatar avatar) {
        this.uid = uid;
        this.avatar = avatar;
    }

    public UpdateUserAvatarChanged() {

    }

    public int getUid() {
        return this.uid;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.uid = values.getInt(1);
        this.avatar = values.optObj(2, new Avatar());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.uid);
        if (this.avatar != null) {
            writer.writeObject(2, this.avatar);
        }
    }

    @Override
    public String toString() {
        String res = "update UserAvatarChanged{";
        res += "uid=" + this.uid;
        res += ", avatar=" + (this.avatar != null ? "set":"empty");
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
