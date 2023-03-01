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


export interface issuebookdetails{
    issue_id:number,
    issueDate: Date,
    issueEndDate: Date,
    returnDate: Date,
    bookTitle:string,
    authors:string[]
    userName: string
    
}

