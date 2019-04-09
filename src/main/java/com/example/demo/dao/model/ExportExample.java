package com.example.demo.dao.model;

import java.util.ArrayList;
import java.util.List;

public class ExportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExportExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andHighIsNull() {
            addCriterion("high is null");
            return (Criteria) this;
        }

        public Criteria andHighIsNotNull() {
            addCriterion("high is not null");
            return (Criteria) this;
        }

        public Criteria andHighEqualTo(String value) {
            addCriterion("high =", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotEqualTo(String value) {
            addCriterion("high <>", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThan(String value) {
            addCriterion("high >", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThanOrEqualTo(String value) {
            addCriterion("high >=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThan(String value) {
            addCriterion("high <", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThanOrEqualTo(String value) {
            addCriterion("high <=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLike(String value) {
            addCriterion("high like", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotLike(String value) {
            addCriterion("high not like", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighIn(List<String> values) {
            addCriterion("high in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotIn(List<String> values) {
            addCriterion("high not in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighBetween(String value1, String value2) {
            addCriterion("high between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotBetween(String value1, String value2) {
            addCriterion("high not between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andH1IsNull() {
            addCriterion("h1 is null");
            return (Criteria) this;
        }

        public Criteria andH1IsNotNull() {
            addCriterion("h1 is not null");
            return (Criteria) this;
        }

        public Criteria andH1EqualTo(String value) {
            addCriterion("h1 =", value, "h1");
            return (Criteria) this;
        }

        public Criteria andH1NotEqualTo(String value) {
            addCriterion("h1 <>", value, "h1");
            return (Criteria) this;
        }

        public Criteria andH1GreaterThan(String value) {
            addCriterion("h1 >", value, "h1");
            return (Criteria) this;
        }

        public Criteria andH1GreaterThanOrEqualTo(String value) {
            addCriterion("h1 >=", value, "h1");
            return (Criteria) this;
        }

        public Criteria andH1LessThan(String value) {
            addCriterion("h1 <", value, "h1");
            return (Criteria) this;
        }

        public Criteria andH1LessThanOrEqualTo(String value) {
            addCriterion("h1 <=", value, "h1");
            return (Criteria) this;
        }

        public Criteria andH1Like(String value) {
            addCriterion("h1 like", value, "h1");
            return (Criteria) this;
        }

        public Criteria andH1NotLike(String value) {
            addCriterion("h1 not like", value, "h1");
            return (Criteria) this;
        }

        public Criteria andH1In(List<String> values) {
            addCriterion("h1 in", values, "h1");
            return (Criteria) this;
        }

        public Criteria andH1NotIn(List<String> values) {
            addCriterion("h1 not in", values, "h1");
            return (Criteria) this;
        }

        public Criteria andH1Between(String value1, String value2) {
            addCriterion("h1 between", value1, value2, "h1");
            return (Criteria) this;
        }

        public Criteria andH1NotBetween(String value1, String value2) {
            addCriterion("h1 not between", value1, value2, "h1");
            return (Criteria) this;
        }

        public Criteria andH2IsNull() {
            addCriterion("h2 is null");
            return (Criteria) this;
        }

        public Criteria andH2IsNotNull() {
            addCriterion("h2 is not null");
            return (Criteria) this;
        }

        public Criteria andH2EqualTo(String value) {
            addCriterion("h2 =", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2NotEqualTo(String value) {
            addCriterion("h2 <>", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2GreaterThan(String value) {
            addCriterion("h2 >", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2GreaterThanOrEqualTo(String value) {
            addCriterion("h2 >=", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2LessThan(String value) {
            addCriterion("h2 <", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2LessThanOrEqualTo(String value) {
            addCriterion("h2 <=", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2Like(String value) {
            addCriterion("h2 like", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2NotLike(String value) {
            addCriterion("h2 not like", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2In(List<String> values) {
            addCriterion("h2 in", values, "h2");
            return (Criteria) this;
        }

        public Criteria andH2NotIn(List<String> values) {
            addCriterion("h2 not in", values, "h2");
            return (Criteria) this;
        }

        public Criteria andH2Between(String value1, String value2) {
            addCriterion("h2 between", value1, value2, "h2");
            return (Criteria) this;
        }

        public Criteria andH2NotBetween(String value1, String value2) {
            addCriterion("h2 not between", value1, value2, "h2");
            return (Criteria) this;
        }

        public Criteria andA3IsNull() {
            addCriterion("a3 is null");
            return (Criteria) this;
        }

        public Criteria andA3IsNotNull() {
            addCriterion("a3 is not null");
            return (Criteria) this;
        }

        public Criteria andA3EqualTo(String value) {
            addCriterion("a3 =", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotEqualTo(String value) {
            addCriterion("a3 <>", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThan(String value) {
            addCriterion("a3 >", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThanOrEqualTo(String value) {
            addCriterion("a3 >=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThan(String value) {
            addCriterion("a3 <", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThanOrEqualTo(String value) {
            addCriterion("a3 <=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3Like(String value) {
            addCriterion("a3 like", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotLike(String value) {
            addCriterion("a3 not like", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3In(List<String> values) {
            addCriterion("a3 in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotIn(List<String> values) {
            addCriterion("a3 not in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3Between(String value1, String value2) {
            addCriterion("a3 between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotBetween(String value1, String value2) {
            addCriterion("a3 not between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA4IsNull() {
            addCriterion("a4 is null");
            return (Criteria) this;
        }

        public Criteria andA4IsNotNull() {
            addCriterion("a4 is not null");
            return (Criteria) this;
        }

        public Criteria andA4EqualTo(String value) {
            addCriterion("a4 =", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotEqualTo(String value) {
            addCriterion("a4 <>", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4GreaterThan(String value) {
            addCriterion("a4 >", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4GreaterThanOrEqualTo(String value) {
            addCriterion("a4 >=", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4LessThan(String value) {
            addCriterion("a4 <", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4LessThanOrEqualTo(String value) {
            addCriterion("a4 <=", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4Like(String value) {
            addCriterion("a4 like", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotLike(String value) {
            addCriterion("a4 not like", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4In(List<String> values) {
            addCriterion("a4 in", values, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotIn(List<String> values) {
            addCriterion("a4 not in", values, "a4");
            return (Criteria) this;
        }

        public Criteria andA4Between(String value1, String value2) {
            addCriterion("a4 between", value1, value2, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotBetween(String value1, String value2) {
            addCriterion("a4 not between", value1, value2, "a4");
            return (Criteria) this;
        }

        public Criteria andR5IsNull() {
            addCriterion("r5 is null");
            return (Criteria) this;
        }

        public Criteria andR5IsNotNull() {
            addCriterion("r5 is not null");
            return (Criteria) this;
        }

        public Criteria andR5EqualTo(String value) {
            addCriterion("r5 =", value, "r5");
            return (Criteria) this;
        }

        public Criteria andR5NotEqualTo(String value) {
            addCriterion("r5 <>", value, "r5");
            return (Criteria) this;
        }

        public Criteria andR5GreaterThan(String value) {
            addCriterion("r5 >", value, "r5");
            return (Criteria) this;
        }

        public Criteria andR5GreaterThanOrEqualTo(String value) {
            addCriterion("r5 >=", value, "r5");
            return (Criteria) this;
        }

        public Criteria andR5LessThan(String value) {
            addCriterion("r5 <", value, "r5");
            return (Criteria) this;
        }

        public Criteria andR5LessThanOrEqualTo(String value) {
            addCriterion("r5 <=", value, "r5");
            return (Criteria) this;
        }

        public Criteria andR5Like(String value) {
            addCriterion("r5 like", value, "r5");
            return (Criteria) this;
        }

        public Criteria andR5NotLike(String value) {
            addCriterion("r5 not like", value, "r5");
            return (Criteria) this;
        }

        public Criteria andR5In(List<String> values) {
            addCriterion("r5 in", values, "r5");
            return (Criteria) this;
        }

        public Criteria andR5NotIn(List<String> values) {
            addCriterion("r5 not in", values, "r5");
            return (Criteria) this;
        }

        public Criteria andR5Between(String value1, String value2) {
            addCriterion("r5 between", value1, value2, "r5");
            return (Criteria) this;
        }

        public Criteria andR5NotBetween(String value1, String value2) {
            addCriterion("r5 not between", value1, value2, "r5");
            return (Criteria) this;
        }

        public Criteria andT6IsNull() {
            addCriterion("t6 is null");
            return (Criteria) this;
        }

        public Criteria andT6IsNotNull() {
            addCriterion("t6 is not null");
            return (Criteria) this;
        }

        public Criteria andT6EqualTo(String value) {
            addCriterion("t6 =", value, "t6");
            return (Criteria) this;
        }

        public Criteria andT6NotEqualTo(String value) {
            addCriterion("t6 <>", value, "t6");
            return (Criteria) this;
        }

        public Criteria andT6GreaterThan(String value) {
            addCriterion("t6 >", value, "t6");
            return (Criteria) this;
        }

        public Criteria andT6GreaterThanOrEqualTo(String value) {
            addCriterion("t6 >=", value, "t6");
            return (Criteria) this;
        }

        public Criteria andT6LessThan(String value) {
            addCriterion("t6 <", value, "t6");
            return (Criteria) this;
        }

        public Criteria andT6LessThanOrEqualTo(String value) {
            addCriterion("t6 <=", value, "t6");
            return (Criteria) this;
        }

        public Criteria andT6Like(String value) {
            addCriterion("t6 like", value, "t6");
            return (Criteria) this;
        }

        public Criteria andT6NotLike(String value) {
            addCriterion("t6 not like", value, "t6");
            return (Criteria) this;
        }

        public Criteria andT6In(List<String> values) {
            addCriterion("t6 in", values, "t6");
            return (Criteria) this;
        }

        public Criteria andT6NotIn(List<String> values) {
            addCriterion("t6 not in", values, "t6");
            return (Criteria) this;
        }

        public Criteria andT6Between(String value1, String value2) {
            addCriterion("t6 between", value1, value2, "t6");
            return (Criteria) this;
        }

        public Criteria andT6NotBetween(String value1, String value2) {
            addCriterion("t6 not between", value1, value2, "t6");
            return (Criteria) this;
        }

        public Criteria andT7IsNull() {
            addCriterion("t7 is null");
            return (Criteria) this;
        }

        public Criteria andT7IsNotNull() {
            addCriterion("t7 is not null");
            return (Criteria) this;
        }

        public Criteria andT7EqualTo(String value) {
            addCriterion("t7 =", value, "t7");
            return (Criteria) this;
        }

        public Criteria andT7NotEqualTo(String value) {
            addCriterion("t7 <>", value, "t7");
            return (Criteria) this;
        }

        public Criteria andT7GreaterThan(String value) {
            addCriterion("t7 >", value, "t7");
            return (Criteria) this;
        }

        public Criteria andT7GreaterThanOrEqualTo(String value) {
            addCriterion("t7 >=", value, "t7");
            return (Criteria) this;
        }

        public Criteria andT7LessThan(String value) {
            addCriterion("t7 <", value, "t7");
            return (Criteria) this;
        }

        public Criteria andT7LessThanOrEqualTo(String value) {
            addCriterion("t7 <=", value, "t7");
            return (Criteria) this;
        }

        public Criteria andT7Like(String value) {
            addCriterion("t7 like", value, "t7");
            return (Criteria) this;
        }

        public Criteria andT7NotLike(String value) {
            addCriterion("t7 not like", value, "t7");
            return (Criteria) this;
        }

        public Criteria andT7In(List<String> values) {
            addCriterion("t7 in", values, "t7");
            return (Criteria) this;
        }

        public Criteria andT7NotIn(List<String> values) {
            addCriterion("t7 not in", values, "t7");
            return (Criteria) this;
        }

        public Criteria andT7Between(String value1, String value2) {
            addCriterion("t7 between", value1, value2, "t7");
            return (Criteria) this;
        }

        public Criteria andT7NotBetween(String value1, String value2) {
            addCriterion("t7 not between", value1, value2, "t7");
            return (Criteria) this;
        }

        public Criteria andU8IsNull() {
            addCriterion("u8 is null");
            return (Criteria) this;
        }

        public Criteria andU8IsNotNull() {
            addCriterion("u8 is not null");
            return (Criteria) this;
        }

        public Criteria andU8EqualTo(String value) {
            addCriterion("u8 =", value, "u8");
            return (Criteria) this;
        }

        public Criteria andU8NotEqualTo(String value) {
            addCriterion("u8 <>", value, "u8");
            return (Criteria) this;
        }

        public Criteria andU8GreaterThan(String value) {
            addCriterion("u8 >", value, "u8");
            return (Criteria) this;
        }

        public Criteria andU8GreaterThanOrEqualTo(String value) {
            addCriterion("u8 >=", value, "u8");
            return (Criteria) this;
        }

        public Criteria andU8LessThan(String value) {
            addCriterion("u8 <", value, "u8");
            return (Criteria) this;
        }

        public Criteria andU8LessThanOrEqualTo(String value) {
            addCriterion("u8 <=", value, "u8");
            return (Criteria) this;
        }

        public Criteria andU8Like(String value) {
            addCriterion("u8 like", value, "u8");
            return (Criteria) this;
        }

        public Criteria andU8NotLike(String value) {
            addCriterion("u8 not like", value, "u8");
            return (Criteria) this;
        }

        public Criteria andU8In(List<String> values) {
            addCriterion("u8 in", values, "u8");
            return (Criteria) this;
        }

        public Criteria andU8NotIn(List<String> values) {
            addCriterion("u8 not in", values, "u8");
            return (Criteria) this;
        }

        public Criteria andU8Between(String value1, String value2) {
            addCriterion("u8 between", value1, value2, "u8");
            return (Criteria) this;
        }

        public Criteria andU8NotBetween(String value1, String value2) {
            addCriterion("u8 not between", value1, value2, "u8");
            return (Criteria) this;
        }

        public Criteria andU9IsNull() {
            addCriterion("u9 is null");
            return (Criteria) this;
        }

        public Criteria andU9IsNotNull() {
            addCriterion("u9 is not null");
            return (Criteria) this;
        }

        public Criteria andU9EqualTo(String value) {
            addCriterion("u9 =", value, "u9");
            return (Criteria) this;
        }

        public Criteria andU9NotEqualTo(String value) {
            addCriterion("u9 <>", value, "u9");
            return (Criteria) this;
        }

        public Criteria andU9GreaterThan(String value) {
            addCriterion("u9 >", value, "u9");
            return (Criteria) this;
        }

        public Criteria andU9GreaterThanOrEqualTo(String value) {
            addCriterion("u9 >=", value, "u9");
            return (Criteria) this;
        }

        public Criteria andU9LessThan(String value) {
            addCriterion("u9 <", value, "u9");
            return (Criteria) this;
        }

        public Criteria andU9LessThanOrEqualTo(String value) {
            addCriterion("u9 <=", value, "u9");
            return (Criteria) this;
        }

        public Criteria andU9Like(String value) {
            addCriterion("u9 like", value, "u9");
            return (Criteria) this;
        }

        public Criteria andU9NotLike(String value) {
            addCriterion("u9 not like", value, "u9");
            return (Criteria) this;
        }

        public Criteria andU9In(List<String> values) {
            addCriterion("u9 in", values, "u9");
            return (Criteria) this;
        }

        public Criteria andU9NotIn(List<String> values) {
            addCriterion("u9 not in", values, "u9");
            return (Criteria) this;
        }

        public Criteria andU9Between(String value1, String value2) {
            addCriterion("u9 between", value1, value2, "u9");
            return (Criteria) this;
        }

        public Criteria andU9NotBetween(String value1, String value2) {
            addCriterion("u9 not between", value1, value2, "u9");
            return (Criteria) this;
        }

        public Criteria andO10IsNull() {
            addCriterion("o10 is null");
            return (Criteria) this;
        }

        public Criteria andO10IsNotNull() {
            addCriterion("o10 is not null");
            return (Criteria) this;
        }

        public Criteria andO10EqualTo(String value) {
            addCriterion("o10 =", value, "o10");
            return (Criteria) this;
        }

        public Criteria andO10NotEqualTo(String value) {
            addCriterion("o10 <>", value, "o10");
            return (Criteria) this;
        }

        public Criteria andO10GreaterThan(String value) {
            addCriterion("o10 >", value, "o10");
            return (Criteria) this;
        }

        public Criteria andO10GreaterThanOrEqualTo(String value) {
            addCriterion("o10 >=", value, "o10");
            return (Criteria) this;
        }

        public Criteria andO10LessThan(String value) {
            addCriterion("o10 <", value, "o10");
            return (Criteria) this;
        }

        public Criteria andO10LessThanOrEqualTo(String value) {
            addCriterion("o10 <=", value, "o10");
            return (Criteria) this;
        }

        public Criteria andO10Like(String value) {
            addCriterion("o10 like", value, "o10");
            return (Criteria) this;
        }

        public Criteria andO10NotLike(String value) {
            addCriterion("o10 not like", value, "o10");
            return (Criteria) this;
        }

        public Criteria andO10In(List<String> values) {
            addCriterion("o10 in", values, "o10");
            return (Criteria) this;
        }

        public Criteria andO10NotIn(List<String> values) {
            addCriterion("o10 not in", values, "o10");
            return (Criteria) this;
        }

        public Criteria andO10Between(String value1, String value2) {
            addCriterion("o10 between", value1, value2, "o10");
            return (Criteria) this;
        }

        public Criteria andO10NotBetween(String value1, String value2) {
            addCriterion("o10 not between", value1, value2, "o10");
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