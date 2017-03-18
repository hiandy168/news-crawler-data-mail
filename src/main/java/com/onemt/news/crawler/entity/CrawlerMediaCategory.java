package com.onemt.news.crawler.entity;

public class CrawlerMediaCategory {

	private Integer id;

    private String name;

    private String url;

    private String regex;

    private String processor;

    private Integer newsCategoryId;

    private Integer newsRegionId;

    private Integer createTime;

    private String creater;

    private Boolean isDelete;

    private Boolean isEnable;

    private Integer mediaId;

    private String mediaName;

    private String mediaIcon;
    
    private String extend;
    
    private String sourceCategory;
    
    //新增字段 2017/1/16 v1.2
    private Integer categoryId;
    private Integer subcategoryId;
    private Integer region;
    
    //新增字段 2017/2/14 v.13
    private String type;
    
    
    public CrawlerMediaCategory() {
	}

	public CrawlerMediaCategory(Integer id, String name, String url,
			String regex, String processor, Integer newsCategoryId,
			Integer newsRegionId, Integer createTime, String creater,
			Boolean isDelete, Boolean isEnable, Integer mediaId,
			String mediaName, String mediaIcon, String extend,
			String sourceCategory, Integer categoryId, Integer subcategoryId,
			Integer region, String type) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.regex = regex;
		this.processor = processor;
		this.newsCategoryId = newsCategoryId;
		this.newsRegionId = newsRegionId;
		this.createTime = createTime;
		this.creater = creater;
		this.isDelete = isDelete;
		this.isEnable = isEnable;
		this.mediaId = mediaId;
		this.mediaName = mediaName;
		this.mediaIcon = mediaIcon;
		this.extend = extend;
		this.sourceCategory = sourceCategory;
		this.categoryId = categoryId;
		this.subcategoryId = subcategoryId;
		this.region = region;
		this.type = type;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getRegex() {
		return regex;
	}


	public void setRegex(String regex) {
		this.regex = regex;
	}


	public String getProcessor() {
		return processor;
	}


	public void setProcessor(String processor) {
		this.processor = processor;
	}


	public Integer getNewsCategoryId() {
		return newsCategoryId;
	}


	public void setNewsCategoryId(Integer newsCategoryId) {
		this.newsCategoryId = newsCategoryId;
	}


	public Integer getNewsRegionId() {
		return newsRegionId;
	}


	public void setNewsRegionId(Integer newsRegionId) {
		this.newsRegionId = newsRegionId;
	}


	public Integer getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}


	public String getCreater() {
		return creater;
	}


	public void setCreater(String creater) {
		this.creater = creater;
	}


	public Boolean getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}


	public Boolean getIsEnable() {
		return isEnable;
	}


	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}


	public Integer getMediaId() {
		return mediaId;
	}


	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}


	public String getMediaName() {
		return mediaName;
	}


	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}


	public String getMediaIcon() {
		return mediaIcon;
	}


	public void setMediaIcon(String mediaIcon) {
		this.mediaIcon = mediaIcon;
	}


	public String getExtend() {
		return extend;
	}


	public void setExtend(String extend) {
		this.extend = extend;
	}


	public String getSourceCategory() {
		return sourceCategory;
	}


	public void setSourceCategory(String sourceCategory) {
		this.sourceCategory = sourceCategory;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public Integer getSubcategoryId() {
		return subcategoryId;
	}


	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}


	public Integer getRegion() {
		return region;
	}


	public void setRegion(Integer region) {
		this.region = region;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
}