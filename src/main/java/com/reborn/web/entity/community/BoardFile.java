package com.reborn.web.entity.community;

public class BoardFile {
	private int id; 
	private int boardId;
	private String fileName;
	private String fileOrigName;
	private String fileUrl;
	
	
	public BoardFile() {
	}


	public BoardFile(int id, int boardId, String fileName, String fileOrigName, String fileUrl) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.fileName = fileName;
		this.fileOrigName = fileOrigName;
		this.fileUrl = fileUrl;
	}


	@Override
	public String toString() {
		return "BoardFile [id=" + id + ", boardId=" + boardId + ", fileName=" + fileName + ", fileOrigName="
				+ fileOrigName + ", fileUrl=" + fileUrl + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileOrigName() {
		return fileOrigName;
	}


	public void setFileOrigName(String fileOrigName) {
		this.fileOrigName = fileOrigName;
	}


	public String getFileUrl() {
		return fileUrl;
	}


	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	
	
	
}
