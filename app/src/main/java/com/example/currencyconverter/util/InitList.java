package com.example.currencyconverter.util;

import com.example.currencyconverter.model2.CurrencyCountry;
import com.example.currencyconverter.model2.Result;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class InitList {

    private List<CurrencyCountry> currencyCountryList;

    public List<CurrencyCountry> getCurrencyCountryList() {
        return currencyCountryList;
    }

    public void initList(Result result) {

        currencyCountryList = Arrays.asList(result.getAf(), result.getAi(), result.getAu(), result.getBd(), result.getBj(),
                result.getBr(), result.getKh(), result.getTd(), result.getCg(), result.getCu(), result.getDm(), result.getFi(),
                result.getGe(), result.getGd(), result.getHt(), result.getIn(), result.getIl(), result.getKz(), result.getKw(),
                result.getLs(), result.getLu(), result.getMy(), result.getMu(), result.getMn(), result.getMm(), result.getNc(),
                result.getNo(), result.getPg(), result.getPt(), result.getRw(), result.getWs(), result.getRs(), result.getSi(),
                result.getEs(), result.getSe(), result.getTz(), result.getTn(), result.getUa(), result.getUz(), result.getYe(),
                result.getDz(), result.getAr(), result.getAz(), result.getBy(), result.getBo(), result.getBg(), result.getCa(),
                result.getCn(), result.getCr(), result.getCz(), result.getEc(), result.getEe(), result.getPf(), result.getGh(),
                result.getGn(), result.getHk(), result.getIr(), result.getJm(), result.getKi(), result.getLa(), result.getLy(),
                result.getMk(), result.getMl(), result.getFm(), result.getMs(), result.getNr(), result.getNi(), result.getPk(),
                result.getPe(), result.getQa(), result.getKn(), result.getSt(), result.getSl(), result.getSo(), result.getSd(),
                result.getSy(), result.getTg(), result.getTm(), result.getGb(), result.getVe(), result.getAd(), result.getAm(),
                result.getBs(), result.getBe(), result.getBa(), result.getBf(), result.getKy(), result.getCo(), result.getCi(),
                result.getDk(), result.getEg(), result.getEt(), result.getGa(), result.getGi(), result.getGw(), result.getHu(),
                result.getIq(), result.getJp(), result.getKp(), result.getLv(), result.getLi(), result.getMg(), result.getMt(),
                result.getMd(), result.getMa(), result.getNp(), result.getNe(), result.getPw(), result.getPh(), result.getRo(),
                result.getLc(), result.getSa(), result.getSg(), result.getZa(), result.getSr(), result.getTw(), result.getTo(),
                result.getTv(), result.getUs(), result.getVn(),result.getAl(),result.getAg(),result.getAt(),result.getBb(),
                result.getBt(),result.getBn(),result.getCm(),result.getCl(),result.getCd(),result.getCy(),result.getDo(),
                result.getEr(),result.getFr(),result.getDe(),result.getGt(),result.getHn(),result.getId(),result.getIt(),
                result.getKe(),result.getKg(),result.getLr(),result.getMo(),result.getMv(),result.getMx(),result.getMe(),
                result.getNa(),result.getNz(),result.getOm(),result.getPy(),result.getPr(),result.getSh(),result.getSm(),
                result.getSc(),result.getSb(),result.getLk(),result.getCh(),result.getTh(),result.getTr(),result.getAe(),
                result.getVu(),result.getZm(),result.getAo(),result.getAw(),result.getBh(),result.getBz(),result.getBw(),
                result.getBi(),result.getCf(),result.getKm(),result.getHr(),result.getDj(),result.getSv(),result.getFj(),
                result.getGm(),result.getGr(),result.getGy(),result.getIs(),result.getIe(),result.getJo(),result.getKr(),
                result.getLb(),result.getMw(),result.getMr(),result.getMc(),result.getMz(),result.getNl(),result.getNg(),
                result.getPa(),result.getPl(),result.getRu(),result.getVc(),result.getSn(),result.getSk(),result.getSs(),
                result.getSz(),result.getTj(),result.getTt(),result.getUg(),result.getUy(),result.getWf(),result.getLt());


    }
}
