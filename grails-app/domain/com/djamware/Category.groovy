package com.djamware

import grails.rest.*;

class Category {

    String catName
    static hasMany = [articles:Article]

    static constraints = {
        catName blank: false
    }
}
