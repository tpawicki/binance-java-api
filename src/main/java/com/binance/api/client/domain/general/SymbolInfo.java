package com.binance.api.client.domain.general;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Symbol information (base/quote).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolInfo {

    private String symbol;

    private SymbolStatus status;

    private String baseAsset;

    private Integer baseAssetPrecision;

    private String quoteAsset;

    private Integer quotePrecision;

    private List<OrderType> orderTypes;

    private boolean icebergAllowed;

    private boolean ocoAllowed;

    private boolean quoteOrderQtyMarketAllowed;

    private boolean isSpotTradingAllowed;

    private boolean isMarginTradingAllowed;

    private List<SymbolFilter> filtersList;
    private Map<FilterType, SymbolFilter> filtersMap;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public SymbolStatus getStatus() {
        return status;
    }

    public void setStatus(SymbolStatus status) {
        this.status = status;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public Integer getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    public void setBaseAssetPrecision(Integer baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public Integer getQuotePrecision() {
        return quotePrecision;
    }

    public void setQuotePrecision(Integer quotePrecision) {
        this.quotePrecision = quotePrecision;
    }

    public List<OrderType> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<OrderType> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public boolean isIcebergAllowed() {
        return icebergAllowed;
    }

    public void setIcebergAllowed(boolean icebergAllowed) {
        this.icebergAllowed = icebergAllowed;
    }

    public boolean isOcoAllowed() {
        return ocoAllowed;
    }

    public void setOcoAllowed(boolean ocoAllowed) {
        this.ocoAllowed = ocoAllowed;
    }

    public boolean isQuoteOrderQtyMarketAllowed() {
        return quoteOrderQtyMarketAllowed;
    }

    public void setQuoteOrderQtyMarketAllowed(boolean quoteOrderQtyMarketAllowed) {
        this.quoteOrderQtyMarketAllowed = quoteOrderQtyMarketAllowed;
    }

    public boolean isSpotTradingAllowed() {
        return isSpotTradingAllowed;
    }

    public void setIsSpotTradingAllowed(boolean isSpotTradingAllowed) {
        this.isSpotTradingAllowed = isSpotTradingAllowed;
    }

    public boolean isMarginTradingAllowed() {
        return isMarginTradingAllowed;
    }

    public void setIsMarginTradingAllowed(boolean isMarginTradingAllowed) {
        this.isMarginTradingAllowed = isMarginTradingAllowed;
    }

    public List<SymbolFilter> getFilters() {
        return filtersList;
    }

    public void setFilters(List<SymbolFilter> filters) {
        filtersList = filters;
        filtersMap = new HashMap<>();
        for (SymbolFilter filter : filters) {
            filtersMap.put(filter.getFilterType(), filter);
        }
    }

    /**
     * @param filterType filter type to filter for.
     * @return symbol filter information for the provided filter type.
     */
    public SymbolFilter getSymbolFilter(FilterType filterType) {
        return filtersMap.get(filterType);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("status", status)
                .append("baseAsset", baseAsset)
                .append("baseAssetPrecision", baseAssetPrecision)
                .append("quoteAsset", quoteAsset)
                .append("quotePrecision", quotePrecision)
                .append("orderTypes", orderTypes)
                .append("icebergAllowed", icebergAllowed)
                .append("filters", filtersList)
                .toString();
    }
}
