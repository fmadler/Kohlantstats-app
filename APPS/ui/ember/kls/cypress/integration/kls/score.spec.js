import {
    program_Les4terres_webPath,
    loic_Les4terres_score_longevity,
    loic_Les4terres_score_first,
    loic_Les4terres_score_second,
    loic_Les4terres_score_total,
    program_Lalegende_webPath,
    loic_Lalegende_score_longevity,
    loic_Lalegende_score_first,
    loic_Lalegende_score_second,
    loic_Lalegende_score_total,
    loic_webPath

}
    from './kls_mock_data';
import {
    goToHomePage,
    goToParticipant,
    checkValue,
    goToPlayer,
}
    from './kls_commons';

const loic_4terre = `${program_Les4terres_webPath}-${loic_webPath}`;
const loic_Lalegende = `${program_Lalegende_webPath}-${loic_webPath}`;

context('Score spec', () => {
    
    beforeEach(() => {
        //goToHomePage()
    })

    it('Check participant displayed score', () => {
        goToParticipant(program_Les4terres_webPath,loic_webPath);
        checkValue(`[data-cy=${loic_4terre}-score-longevity]`, loic_Les4terres_score_longevity)
        checkValue(`[data-cy=${loic_4terre}-score-1]`, loic_Les4terres_score_first)
        checkValue(`[data-cy=${loic_4terre}-score-2]`, loic_Les4terres_score_second)
        checkValue(`[data-cy=${loic_4terre}-score-total]`, loic_Les4terres_score_total)
    })

    it('Check player comparison displayed score', () => {
        goToParticipant(program_Lalegende_webPath,loic_webPath);
        checkValue(`[data-cy=${loic_Lalegende}-score-longevity]`, loic_Lalegende_score_longevity)
        checkValue(`[data-cy=${loic_Lalegende}-score-1]`, loic_Lalegende_score_first)
        checkValue(`[data-cy=${loic_Lalegende}-score-2]`, loic_Lalegende_score_second)
        checkValue(`[data-cy=${loic_Lalegende}-score-total]`, loic_Lalegende_score_total)
    })

    it('Check player comparison displayed score', () => {
        goToPlayer(loic_webPath);
        checkValue(`[data-cy=${loic_4terre}-score-longevity]`, loic_Les4terres_score_longevity)
        checkValue(`[data-cy=${loic_4terre}-score-1]`, loic_Les4terres_score_first)
        checkValue(`[data-cy=${loic_4terre}-score-2]`, loic_Les4terres_score_second)
        checkValue(`[data-cy=${loic_4terre}-score-total]`, loic_Les4terres_score_total)
        checkValue(`[data-cy=${loic_Lalegende}-score-longevity]`, loic_Lalegende_score_longevity)
        checkValue(`[data-cy=${loic_Lalegende}-score-1]`, loic_Lalegende_score_first)
        checkValue(`[data-cy=${loic_Lalegende}-score-2]`, loic_Lalegende_score_second)
        checkValue(`[data-cy=${loic_Lalegende}-score-total]`, loic_Lalegende_score_total)
    })

})
