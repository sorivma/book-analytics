package com.example.bookanalytics.controllers.responce;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {
}
