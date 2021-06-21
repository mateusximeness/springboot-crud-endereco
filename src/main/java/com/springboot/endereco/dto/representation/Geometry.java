package com.springboot.endereco.dto.representation;

import lombok.Data;

public @Data class Geometry{
	private Viewport viewport;
	private Location location;
	private String locationType;
}