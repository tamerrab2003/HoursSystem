package edu.mufic.hourssystem.dao.entity;

public enum Degree {
	
	ASSOCIATE("Degree.name.ASSOCIATE", "Degree.description.ASSOCIATE", 3, 100, 0),
	BACHELOR("Degree.name.BACHELOR", "Degree.description.BACHELOR", 4, 16, 1),
	DIPLOMA("Degree.name.DIPLOMA", "Degree.description.DIPLOMA", 1, 3, 2),
	MASTER("Degree.name.MASTER", "Degree.description.MASTER", 2, 9, 3),
	DOCTORAL("Degree.name.DOCTORAL", "Degree.description.DOCTORAL", 2, 9, 4),
	EXPERIENCE_BASED("Degree.name.EXPERIENCE_BASED", "Degree.description.EXPERIENCE_BASED", 1, 100, 5);
	
	private String nameKey;
	private String descriptionKey;
	private Integer minDuration;
	private Integer maxDuration;
	private int typeCode;
	
	private Degree( String nameKey, String descriptionKey, Integer minDuration, Integer maxDuration, int typeCode) {
		this.nameKey = nameKey;
		this.descriptionKey = descriptionKey;
		this.minDuration = minDuration;
		this.maxDuration = maxDuration;
		this.typeCode = typeCode;
	}
	
	public static Degree fromInt(int typeCode) {
		for(Degree d: values()) {
			if(d.typeCode == typeCode) {
				return d;
			}
		}
		return null;
	}
	
	public int toInt() {
		return this.getTypeCode();
	}

	public String getNameKey() {
		return nameKey;
	}

	public String getDescriptionKey() {
		return descriptionKey;
	}

	public Integer getMinDuration() {
		return minDuration;
	}

	public Integer getMaxDuration() {
		return maxDuration;
	}

	public int getTypeCode() {
		return typeCode;
	}
}
