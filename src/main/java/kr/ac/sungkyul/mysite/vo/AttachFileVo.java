package kr.ac.sungkyul.mysite.vo;

public class AttachFileVo {
	
	private Long no;
	private Long bbsNo;
	private String path;
	private String orgName;
	private String saveName;
	private Long fileSize;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(Long bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	@Override
	public String toString() {
		return "AttachFileVo [no=" + no + ", bbsNo=" + bbsNo + ", path=" + path + ", orgName=" + orgName + ", saveName="
				+ saveName + ", fileSize=" + fileSize + "]";
	}
	
	

}
