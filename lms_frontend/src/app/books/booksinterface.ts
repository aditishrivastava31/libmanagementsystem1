export interface book{
    quantity:number,
    bookName:string,
    authors:authors[]
    category:Category

}

export interface Category{
    categoryName:string
}
export interface authors{
    authorName:string
}
export interface authors{
    authorName:string,
    
}

export interface bookdto{
    book_id: number,
    book_title:string,
    quantity: number,
    authors: string[],
    category: string
}