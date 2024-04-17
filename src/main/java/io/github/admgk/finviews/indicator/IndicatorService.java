package io.github.admgk.finviews.indicator;

import io.github.admgk.finviews.utils.IndName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

@Service
class IndicatorService {
    private AnnualInflationRepository repository;

    IndicatorService(AnnualInflationRepository repository) {
        this.repository = repository;
    }

    IndicatorDTO findAll() {
        List<? extends Indicator> indList = repository.findAll();
        return convertToDTO(indList);
    }
    
    // private final Logger logger = LoggerFactory.getLogger(IndicatorService.class);

    // IndicatorDTO invokeRepositoryOf(String indicator) {
    //     var indName = validateIndParameter(indicator);
    //     List<? extends Indicator> indList;
    //     switch (indName) {
    //         case INFLATION:
    //             indList = new AnnualInflationRepository().findAll();
    //             return convertToDTO(indList);
    //         case AVERAGE_SALARY:
    //             indList = new AverageSalaryRepository().findAll();
    //             return convertToDTO(indList);
    //         default:
    //             indList = new AnnualInflationRepository().findAll();
    //             return convertToDTO(indList);
    //     }
    // }

    // IndName validateIndParameter(String indicator) {
    //     Integer indOrdinal = null;
    //     try {
    //         indOrdinal = Integer.valueOf(indicator);
    //     } catch (NumberFormatException e) {
    //         logger.warn("Non numeric indicator ID used " + indicator);
    //     }

    //     for (IndName ind : IndName.values()) {
    //         if (ind.ordinal() == indOrdinal) {
    //             return ind;
    //         }
    //     }
    //     return IndName.INFLATION;
    // }

    IndicatorDTO convertToDTO(List<? extends Indicator> indList) {
        var name = indList.get(0).getNAME();
        var periodType = indList.get(0).getPERIOD_TYPE();
        var values = new TreeMap<LocalDate, BigDecimal>();
        for (Indicator ind : indList) {
            values.put(ind.getPeriod().toLocalDate(), ind.getValue());
        }
        return new IndicatorDTO(name, periodType, values);
    }
}
