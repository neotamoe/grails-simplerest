package simplerest

import com.djamware.*
import grails.converters.JSON
import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        def category = new Category(catName:"Programming")
            .addToArticles(new Article(title:"How to Create Grails Web Application",author:"Didin J.",description:"Step by step tutorial on how to create Grails web application from scratch", content:"Step by step tutorial on how to create Grails web application from scratch"))
            .save(flush: true)
        articleMarshaler()
    }

    def destroy = {
    }

    private void articleMarshaler() {
        JSON.registerObjectMarshaller(Category) { cat ->
            [
                id: cat.id,
                name: cat.catName,
                article: cat.articles.collect { article ->
                    [
                        id: article.id,
                        title: article.title,
                        author: article.author,
                        description: article.description,
                        content: article.content,
                        created: new SimpleDateFormat("dd/MM/yyyy").format(article.createDate)
                    ]
                }
            ]
        }
    }
}
