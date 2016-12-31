package com.ubb.map.services;

import com.ubb.map.domain.Candidate;
import com.ubb.map.domain.Department;
import com.ubb.map.domain.Option;
import com.ubb.map.exception.DuplicateEntryException;
import com.ubb.map.exception.InvalidObjectException;
import com.ubb.map.helper.generator.RandomGenerator;
import com.ubb.map.repository.RepositoryInterface;
import com.ubb.map.repository.db.CandidateRepository;
import com.ubb.map.repository.db.DepartmentRepository;
import com.ubb.map.repository.db.OptionRepository;
import com.ubb.map.validator.OptionValidator;
import com.ubb.map.validator.ValidatorInterface;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

/**
 * Created by marius on 10/16/16.
 */
@Singleton
public class OptionCrudService {
    private RepositoryInterface<Integer, Option>     optionRepository;
    private RepositoryInterface<Integer, Candidate>  candidateRepository;
    private RepositoryInterface<Integer, Department> departmentRepository;
    private ValidatorInterface<Option>      validator;

    @Inject
    public OptionCrudService(
            OptionRepository     optionRepository,
            CandidateRepository  candidateRepository,
            DepartmentRepository departmentRepository,
            OptionValidator      validator
    )
    {
        this.optionRepository = optionRepository;
        this.candidateRepository = candidateRepository;
        this.departmentRepository = departmentRepository;
        this.validator = validator;
    }

    public Option create(String cid, String departmentId) throws InvalidObjectException, DuplicateEntryException {
        Integer candidateIt = null;

        try {
            if (!cid.isEmpty()) {
                candidateIt = Integer.parseInt(cid);
            }
        }catch (NumberFormatException e) {
            throw new InvalidObjectException("Invalid id: " + e.getMessage());
        }

        Option option = new Option(
                RandomGenerator.getRandomPositiveInt(),
                this.candidateRepository.findById(candidateIt),
                this.departmentRepository.findById(Integer.valueOf(departmentId))
        );

        this.validator.validate(option);
        this.optionRepository.insert(option);

        return option;
    }

    public Option update(Integer optionId, String newCandidateId, String newDepartmentId) throws InvalidObjectException {
        Option option = this.optionRepository.findById(optionId);

        if (!newCandidateId.isEmpty()) {
            option.setCandidate(this.candidateRepository.findById(Integer.parseInt(newCandidateId)));
        }

        if (!newDepartmentId.isEmpty()) {
            option.setDepartment(this.departmentRepository.findById(Integer.valueOf(newDepartmentId)));
        }
        this.validator.validate(option);
        this.optionRepository.update(option);

        return option;
    }

    public Option delete(Integer id) {
        return this.optionRepository.delete(id);
    }

    public Collection<Option> getAll() {
        return this.optionRepository.getAll();
    }
}