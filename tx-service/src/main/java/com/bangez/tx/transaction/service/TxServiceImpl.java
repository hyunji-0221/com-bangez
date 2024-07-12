package com.bangez.tx.transaction.service;

import com.bangez.tx.point.repository.PointRepository;
import com.bangez.tx.transaction.domain.TxModel;
import com.bangez.tx.transaction.repository.TxRepository;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class TxServiceImpl {

    private final TxRepository txRepository;
    private final PointRepository pointRepository;

    public void saveTx(TxModel tx) {
        txRepository.save(tx);
    }

    public List<TxModel> getTxList() {
        return txRepository.findAll();
    }

    public TxModel getTxDetail(Long id) {
        return txRepository.findById(id).orElseThrow(null);
    }

}
