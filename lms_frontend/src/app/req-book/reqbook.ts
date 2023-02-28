enum isActive{
    Cancelled,
    Pending,
    Pending_Purchase,
    Approved
}

export class requestbookdetails{
    constructor(
    requestBookId:number,
    authorName:string,
    bookName:string,
    isActive:isActive,
    ){}
}

export class requestbookdto{
authorName: any;
bookName: any;
isActive: any;
    constructor(
        requestBookId:number,
        authorName:string,
        bookName:string,
        isActive:isActive
    ){}
}