create or replace view v_timeline_abstract as
select full_web_path,
       context_web_path,
       entity_web_path,
       max_score,
       nb_participants - count(*) ranking,
       count(*) nb_participants_behind_score,
       nb_participants
from
    (
        select xxx.full_web_path,
               xxx.CONTEXT_WEB_PATH,
               xxx.entity_web_path,
               xxx.max_score,
               uuu.nb_participants,
               yyy.entity_web_path concurrent_web_path,
               yyy.max_score concurrent_max_score
        from (
                 select full_web_path, context_web_path, entity_web_path, max(score) max_score
                 from dw_timeline_score
                 group by entity_web_path, context_web_path
             ) xxx,
             (
                 select context_web_path, entity_web_path, max(score) max_score
                 from dw_timeline_score
                 group by entity_web_path, context_web_path
             ) yyy,
             (
                 select xxx.CONTEXT_WEB_PATH, count(*) nb_participants
                 from (
                          select context_web_path, entity_web_path, max(score) max_score
                          from dw_timeline_score
                          group by entity_web_path, context_web_path
                      ) xxx
                 group by xxx.CONTEXT_WEB_PATH
             ) uuu
        where xxx.CONTEXT_WEB_PATH = yyy.context_web_path
          and xxx.ENTITY_WEB_PATH != yyy.ENTITY_WEB_PATH
          and xxx.CONTEXT_WEB_PATH = uuu.context_web_path
          and xxx.max_score > yyy.max_score
    ) zzz
group by context_web_path, entity_web_path
;
