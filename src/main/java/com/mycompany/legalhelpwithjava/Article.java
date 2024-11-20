package com.mycompany.legalhelpwithjava;

public class Article {
    public String titleArticle;
    public String ArticleContent;
    public String pasal;

    public Article(String titleArticle, String ArticleContent, String pasal) {
        this.titleArticle = titleArticle;
        this.ArticleContent = ArticleContent;
        this.pasal = pasal;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public String getArticleContent() {
        return ArticleContent;
    }

    public String getPasal() {
        return pasal;
    }
    
    public void displayArticle(){
        System.out.println("Judul: " + titleArticle);
        System.out.println("Konten: " + ArticleContent);
        System.out.println("Pasal: " + pasal);
    }
}
