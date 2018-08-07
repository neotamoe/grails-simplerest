package com.djamware

import grails.rest.*;

@Resource(uri='/category')
class Category {

    String catName
    static hasMany = [articles:Article]

    static constraints = {
        catName blank: false
    }
}
