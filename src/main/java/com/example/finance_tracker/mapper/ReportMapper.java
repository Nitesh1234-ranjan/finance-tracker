package com.example.finance_tracker.mapper;

import com.example.finance_tracker.dto.ReportDTO;
import com.example.finance_tracker.model.Report;

import java.util.List;
import java.util.stream.Collectors;

public class ReportMapper {

    public static Report toEntity(ReportDTO dto) {
        if (dto == null) return null;
        Report report = new Report();
        report.setTotalIncome(dto.getTotalIncome());
        report.setTotalExpense(dto.getTotalExpense());
        report.setBalance(dto.getBalance());
        return report;
    }

    public static ReportDTO toDTO(Report entity) {
        if (entity == null) return null;
        return new ReportDTO(
                entity.getTotalIncome(),
                entity.getTotalExpense(),
                entity.getBalance()
        );
    }

    public static List<ReportDTO> toDTOList(List<Report> reports) {
        return reports.stream()
                .map(ReportMapper::toDTO)
                .collect(Collectors.toList());
    }
}
