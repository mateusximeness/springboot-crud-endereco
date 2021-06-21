package com.springboot.endereco.dto.representation;

import java.util.List;
import lombok.Data;

public @Data class CoordenadasResponse {
	private List<ResultsItem> results;
	private String status;
}