package framework.lisi.entity;


public class FileInfo extends BaseEntity<FileInfo> {

	private static final long serialVersionUID = 1L;
	private String name; // 文件名（含扩展名）
	private String type; // 文件类别
	private String path; // 文件实际存储位置和文件名
	private String size; // 文件大小b
	private String businessId; // 业务Id
	private String businessKey; // 　业务类型

	public FileInfo() {
		super();
	}

	public FileInfo(String id, String name, String type, String path, String size,
			String businessId, String businessKey) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.path = path;
		this.size = size;
		this.businessId = businessId;
		this.businessKey = businessKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
	
	/**
	 * 1
	 */
	public static final String BUSINESSKEY_1 = "1";

}
