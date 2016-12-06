package com.entity;

public class Desk {
	private int desk_id;
	private String desk_name;
	private int desk_status;
	public int getDesk_id() {
		return desk_id;
	}
	public void setDesk_id(int deskId) {
		desk_id = deskId;
	}
	public String getDesk_name() {
		return desk_name;
	}
	public void setDesk_name(String deskName) {
		desk_name = deskName;
	}
	public int getDesk_status() {
		return desk_status;
	}
	public void setDesk_status(int deskStatus) {
		desk_status = deskStatus;
	}
	@Override
	public String toString() {
		return "Desk [desk_id=" + desk_id + ", desk_name=" + desk_name
				+ ", desk_status=" + desk_status + "]";
	}
}
