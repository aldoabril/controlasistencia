/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informaticadev.util;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author CARLOS
 */
public class Paginado implements Serializable {

    private Integer page;
    private Integer size;
    private Integer totalPage;
    private String search;
    private List items;

    public static Paginado build(Integer page, Integer size, String search, Long totalRows, List items) {
        Paginado paginado = new Paginado();
        paginado.setPage(page);
        paginado.setSize(size);
        paginado.setSearch(search);

        double t = (totalRows + 0.0) / size;
        paginado.setTotalPage((int) Math.ceil(t));
        paginado.setItems(items);
        return paginado;
    }

    public Paginado() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
