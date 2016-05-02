/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Simo
 */
public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        init();
    }
    
    private void init() {
        matcher = new Matcher() {
            @Override
            public boolean matches(Player p) {
                return true;
            }
        };
    }

    public Matcher build() {
        Matcher m = this.matcher;
        init();
        return m;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(new PlaysIn(team), this.matcher);
        return this;
    }

    public QueryBuilder hasAtLeast(int number, String what) {
        this.matcher = new And(new HasAtLeast(number, what), this.matcher);
        return this;
    }

    public QueryBuilder hasFewerThan(int number, String what) {
        this.matcher = new And(new HasFewerThan(number, what), this.matcher);
        return this;
    }

    public QueryBuilder allOf(Matcher... matchers) {
        this.matcher = new And(matchers);
        return this;
    }

    public QueryBuilder not(Matcher... matchers) {
        this.matcher = new Not(matchers);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
}
