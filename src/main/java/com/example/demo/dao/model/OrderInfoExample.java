package com.example.demo.dao.model;

import java.util.ArrayList;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andShoeIdIsNull() {
            addCriterion("shoe_id is null");
            return (Criteria) this;
        }

        public Criteria andShoeIdIsNotNull() {
            addCriterion("shoe_id is not null");
            return (Criteria) this;
        }

        public Criteria andShoeIdEqualTo(Integer value) {
            addCriterion("shoe_id =", value, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdNotEqualTo(Integer value) {
            addCriterion("shoe_id <>", value, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdGreaterThan(Integer value) {
            addCriterion("shoe_id >", value, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoe_id >=", value, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdLessThan(Integer value) {
            addCriterion("shoe_id <", value, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdLessThanOrEqualTo(Integer value) {
            addCriterion("shoe_id <=", value, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdIn(List<Integer> values) {
            addCriterion("shoe_id in", values, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdNotIn(List<Integer> values) {
            addCriterion("shoe_id not in", values, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdBetween(Integer value1, Integer value2) {
            addCriterion("shoe_id between", value1, value2, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shoe_id not between", value1, value2, "shoeId");
            return (Criteria) this;
        }

        public Criteria andShoeColorIsNull() {
            addCriterion("shoe_color is null");
            return (Criteria) this;
        }

        public Criteria andShoeColorIsNotNull() {
            addCriterion("shoe_color is not null");
            return (Criteria) this;
        }

        public Criteria andShoeColorEqualTo(String value) {
            addCriterion("shoe_color =", value, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorNotEqualTo(String value) {
            addCriterion("shoe_color <>", value, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorGreaterThan(String value) {
            addCriterion("shoe_color >", value, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorGreaterThanOrEqualTo(String value) {
            addCriterion("shoe_color >=", value, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorLessThan(String value) {
            addCriterion("shoe_color <", value, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorLessThanOrEqualTo(String value) {
            addCriterion("shoe_color <=", value, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorLike(String value) {
            addCriterion("shoe_color like", value, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorNotLike(String value) {
            addCriterion("shoe_color not like", value, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorIn(List<String> values) {
            addCriterion("shoe_color in", values, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorNotIn(List<String> values) {
            addCriterion("shoe_color not in", values, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorBetween(String value1, String value2) {
            addCriterion("shoe_color between", value1, value2, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeColorNotBetween(String value1, String value2) {
            addCriterion("shoe_color not between", value1, value2, "shoeColor");
            return (Criteria) this;
        }

        public Criteria andShoeSizeIsNull() {
            addCriterion("shoe_size is null");
            return (Criteria) this;
        }

        public Criteria andShoeSizeIsNotNull() {
            addCriterion("shoe_size is not null");
            return (Criteria) this;
        }

        public Criteria andShoeSizeEqualTo(String value) {
            addCriterion("shoe_size =", value, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeNotEqualTo(String value) {
            addCriterion("shoe_size <>", value, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeGreaterThan(String value) {
            addCriterion("shoe_size >", value, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeGreaterThanOrEqualTo(String value) {
            addCriterion("shoe_size >=", value, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeLessThan(String value) {
            addCriterion("shoe_size <", value, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeLessThanOrEqualTo(String value) {
            addCriterion("shoe_size <=", value, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeLike(String value) {
            addCriterion("shoe_size like", value, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeNotLike(String value) {
            addCriterion("shoe_size not like", value, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeIn(List<String> values) {
            addCriterion("shoe_size in", values, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeNotIn(List<String> values) {
            addCriterion("shoe_size not in", values, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeBetween(String value1, String value2) {
            addCriterion("shoe_size between", value1, value2, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoeSizeNotBetween(String value1, String value2) {
            addCriterion("shoe_size not between", value1, value2, "shoeSize");
            return (Criteria) this;
        }

        public Criteria andShoePriceIsNull() {
            addCriterion("shoe_price is null");
            return (Criteria) this;
        }

        public Criteria andShoePriceIsNotNull() {
            addCriterion("shoe_price is not null");
            return (Criteria) this;
        }

        public Criteria andShoePriceEqualTo(String value) {
            addCriterion("shoe_price =", value, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceNotEqualTo(String value) {
            addCriterion("shoe_price <>", value, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceGreaterThan(String value) {
            addCriterion("shoe_price >", value, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceGreaterThanOrEqualTo(String value) {
            addCriterion("shoe_price >=", value, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceLessThan(String value) {
            addCriterion("shoe_price <", value, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceLessThanOrEqualTo(String value) {
            addCriterion("shoe_price <=", value, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceLike(String value) {
            addCriterion("shoe_price like", value, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceNotLike(String value) {
            addCriterion("shoe_price not like", value, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceIn(List<String> values) {
            addCriterion("shoe_price in", values, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceNotIn(List<String> values) {
            addCriterion("shoe_price not in", values, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceBetween(String value1, String value2) {
            addCriterion("shoe_price between", value1, value2, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoePriceNotBetween(String value1, String value2) {
            addCriterion("shoe_price not between", value1, value2, "shoePrice");
            return (Criteria) this;
        }

        public Criteria andShoeAmountIsNull() {
            addCriterion("shoe_amount is null");
            return (Criteria) this;
        }

        public Criteria andShoeAmountIsNotNull() {
            addCriterion("shoe_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShoeAmountEqualTo(String value) {
            addCriterion("shoe_amount =", value, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountNotEqualTo(String value) {
            addCriterion("shoe_amount <>", value, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountGreaterThan(String value) {
            addCriterion("shoe_amount >", value, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountGreaterThanOrEqualTo(String value) {
            addCriterion("shoe_amount >=", value, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountLessThan(String value) {
            addCriterion("shoe_amount <", value, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountLessThanOrEqualTo(String value) {
            addCriterion("shoe_amount <=", value, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountLike(String value) {
            addCriterion("shoe_amount like", value, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountNotLike(String value) {
            addCriterion("shoe_amount not like", value, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountIn(List<String> values) {
            addCriterion("shoe_amount in", values, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountNotIn(List<String> values) {
            addCriterion("shoe_amount not in", values, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountBetween(String value1, String value2) {
            addCriterion("shoe_amount between", value1, value2, "shoeAmount");
            return (Criteria) this;
        }

        public Criteria andShoeAmountNotBetween(String value1, String value2) {
            addCriterion("shoe_amount not between", value1, value2, "shoeAmount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}