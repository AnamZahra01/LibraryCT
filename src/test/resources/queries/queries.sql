select * from books;
select name from book_categories;
select bc.name,count(*)
    from book_categories as bc
        join books b
            on bc.id = b.book_category_id
        join book_borrow bb
            on b.id = bb.book_id
group by name
order by 2 desc ;


select bc.name,count(*) from book_borrow bb
                                 inner  join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;