package com.cheney.satisfy.service;

import com.cheney.satisfy.model.Paper;


public interface PaperService extends BaseService<Paper> {

    Paper generateExercisePaper(Paper paper);

}
