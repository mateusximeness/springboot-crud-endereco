package com.springboot.endereco.dto.representation;

import lombok.Data;

public @Data class ResultsItem{
	private Geometry geometry;
	private String placeId;
}