package com.onemt.news.crawler.entity;


public class CrawlerArticle {
	
    
    public CrawlerArticle(){
    }
    
    public CrawlerArticle(Long id, Integer mediaCategoryId, Integer mediaId,
			String sourceUrl, String title, String tags, Long fetchTime,
			Long publishTime, Integer readCount, Integer commentCount,
			Integer likeCount, String author, String type, String sourceUrlMd5,
			String lang, Byte isFeatured, Integer newsCategoryId,
			Integer regionId, String contentUrl, String mediaName,
			String mediaIcon, String sourceCategory, Integer categoryId,
			Integer subcategoryId, Integer region, String videoId,
			Integer videoTime) {
		super();
		this.id = id;
		this.mediaCategoryId = mediaCategoryId;
		this.mediaId = mediaId;
		this.sourceUrl = sourceUrl;
		this.title = title;
		this.tags = tags;
		this.fetchTime = fetchTime;
		this.publishTime = publishTime;
		this.readCount = readCount;
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.author = author;
		this.type = type;
		this.sourceUrlMd5 = sourceUrlMd5;
		this.lang = lang;
		this.isFeatured = isFeatured;
		this.newsCategoryId = newsCategoryId;
		this.regionId = regionId;
		this.contentUrl = contentUrl;
		this.mediaName = mediaName;
		this.mediaIcon = mediaIcon;
		this.sourceCategory = sourceCategory;
		this.categoryId = categoryId;
		this.subcategoryId = subcategoryId;
		this.region = region;
		this.videoId = videoId;
		this.videoTime = videoTime;
	}



	private Long id;

    private Integer mediaCategoryId;

    private Integer mediaId;

    private String sourceUrl;

    private String title;

    private String tags;

    private Long fetchTime;

    private Long publishTime;

    private Integer readCount;

    private Integer commentCount;

    private Integer likeCount;

    private String author;

    private String type;

    private String sourceUrlMd5;

    private String lang;

    private Byte isFeatured;

    private Integer newsCategoryId;

    private Integer regionId;

    private String contentUrl;

    private String mediaName;

    private String mediaIcon;
    
    private String sourceCategory;
    
    //新增字段 2017/1/16 v1.2
    private Integer categoryId;
    private Integer subcategoryId;
    private Integer region;
    
    //新增字段 2017/3/13 v1.4
    public String videoId; //视频id
	public Integer videoTime; //视频时间，单位秒
    

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

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMediaCategoryId() {
        return mediaCategoryId;
    }

    public void setMediaCategoryId(Integer mediaCategoryId) {
        this.mediaCategoryId = mediaCategoryId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceUrlMd5() {
        return sourceUrlMd5;
    }

    public void setSourceUrlMd5(String sourceUrlMd5) {
        this.sourceUrlMd5 = sourceUrlMd5;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public Long getFetchTime() {
		return fetchTime;
	}

	public void setFetchTime(Long fetchTime) {
		this.fetchTime = fetchTime;
	}

	public Long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}

	public Byte getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(Byte isFeatured) {
		this.isFeatured = isFeatured;
	}

	public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
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
    
	public String getSourceCategory() {
		return sourceCategory;
	}

	public void setSourceCategory(String sourceCategory) {
		this.sourceCategory = sourceCategory;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public Integer getVideoTime() {
		return videoTime;
	}

	public void setVideoTime(Integer videoTime) {
		this.videoTime = videoTime;
	}
	
	
}