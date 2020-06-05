package com.statusraja.admin.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileDetailsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer srid;
	private Integer formatid;
	private String type;
	private String filefullname;
	private String fileshortname;
	private String description;
	private String language;
	private String category;
	private String filename;
	private String file_url;
	private String file_duration;
	private String filePath;
	private String extension;
	private String fileStatus;
	private String banner_img;
	private Date createddate;
	private Date updateddate;

	private String statusContent;
	private String actor;
	private Integer likes;
	private Integer downloadcount;
	
	MultipartFile file;
	
	
	
	public Integer getSrid() {
		return srid;
	}

	public void setSrid(Integer srid) {
		this.srid = srid;
	}

	public String getFilefullname() {
		return filefullname;
	}

	public void setFilefullname(String filefullname) {
		this.filefullname = filefullname;
	}

	public String getFileshortname() {
		return fileshortname;
	}

	public void setFileshortname(String fileshortname) {
		this.fileshortname = fileshortname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public Integer getFormatid() {
		return formatid;
	}

	public void setFormatid(Integer formatid) {
		this.formatid = formatid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBanner_img() {
		return banner_img;
	}

	public void setBanner_img(String banner_img) {
		this.banner_img = banner_img;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDownloadcount() {
		return downloadcount;
	}

	public void setDownloadcount(Integer downloadcount) {
		this.downloadcount = downloadcount;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	
	public String getStatusContent() {
		return statusContent;
	}

	public void setStatusContent(String statusContent) {
		this.statusContent = statusContent;
	}
	
	public String getFile_duration() {
		return file_duration;
	}

	public void setFile_duration(String file_duration) {
		this.file_duration = file_duration;
	}

	@Override
	public String toString() {
		return "FileDetailsVo [srid=" + srid + ", formatid=" + formatid + ", type=" + type + ", filefullname="
				+ filefullname + ", fileshortname=" + fileshortname + ", description=" + description + ", language="
				+ language + ", category=" + category + ", filename=" + filename + ", file_url=" + file_url
				+ ", file_duration=" + file_duration + ", filePath=" + filePath + ", extension=" + extension
				+ ", fileStatus=" + fileStatus + ", banner_img=" + banner_img + ", createddate=" + createddate
				+ ", updateddate=" + updateddate + ", statusContent=" + statusContent + ", actor=" + actor + ", likes="
				+ likes + ", downloadcount=" + downloadcount + ", file=" + file + "]";
	}

}
