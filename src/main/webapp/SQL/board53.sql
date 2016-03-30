--board53.sql

create table board53(
    board_num number(38) primary key
  , board_name varchar2(50) not null
  , board_pass varchar2(30) not null
  , board_subject varchar2(100) not null
  , board_content varchar2(4000) not null
  , board_re_ref number /*占쏙옙 占쌓뤄옙占싫�:占썰변占쏙옙 */
  , board_re_lev number /*占썰변占쏙옙 占쏙옙占쏙옙 占쏙옙 */
  , board_re_seq number /*占썰변占쏙옙 화占썽에 占쏙옙占싱댐옙 占쏙옙치 */
  , board_readcount number /*占쏙옙회占쏙옙*/
  , board_date date /*占쏙옙毬占승�*/
);
--
create sequence board53_num_seq
                increment by 1 start with 1 nocache;
--占쏙옙 캐占쏙옙占쏙옙 占쏙옙占쏙옙玖占� 캐占쏙옙占쏙옙 占쏙옙호占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占십는댐옙.
--increment by 1 start 占실미댐옙 1占쏙옙占쏙옙 占쏙옙占쏙옙占쌔쇽옙 1占쏙옙占쏙옙占쏙옙 
                
select * from board53; 

--select * from tab;
commit;