package com.busyzero.demo.netty.live.entity;

public class Client {
     private Long id;
     private int roomId;
     public Client() {
         id = 0L;
         roomId = 0;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
