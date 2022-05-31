//import klsDataUtil from 'kohlantstats/utils/quizz-utils';
import {
  affect,
  unaffect,
  getChoicesResultsForAffectation,
  isResultSetCorrectForCheckedOptions

}
  from 'kohlantstats/utils/quizz-utils';

import {module, test} from 'qunit';

const scoreTimeline =
  {
    "ScoreTimelineOut":
      [
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 1,
          "score": 1.0000,
          "longevity": 1.0000,
          "gameScore1": 0.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 2,
          "score": 2.0000,
          "longevity": 2.0000,
          "gameScore1": 0.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 3,
          "score": 3.0000,
          "longevity": 3.0000,
          "gameScore1": 0.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 4,
          "score": 4.0000,
          "longevity": 4.0000,
          "gameScore1": 0.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 5,
          "score": 5.0000,
          "longevity": 5.0000,
          "gameScore1": 0.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 6,
          "score": 6.0000,
          "longevity": 6.0000,
          "gameScore1": 0.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 7,
          "score": 27.0000,
          "longevity": 7.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 8,
          "score": 28.0000,
          "longevity": 8.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 9,
          "score": 29.0000,
          "longevity": 9.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 10,
          "score": 30.0000,
          "longevity": 10.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 11,
          "score": 31.0000,
          "longevity": 11.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 12,
          "score": 32.0000,
          "longevity": 12.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 13,
          "score": 33.0000,
          "longevity": 13.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 14,
          "score": 34.0000,
          "longevity": 14.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 15,
          "score": 35.0000,
          "longevity": 15.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 16,
          "score": 36.0000,
          "longevity": 16.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 17,
          "score": 37.0000,
          "longevity": 17.0000,
          "gameScore1": 20.0000,
          "gameScore2": 0.0000
        }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 18,
        "score": 38.0000,
        "longevity": 18.0000,
        "gameScore1": 20.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 19,
        "score": 39.0000,
        "longevity": 19.0000,
        "gameScore1": 20.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 20,
        "score": 40.0000,
        "longevity": 20.0000,
        "gameScore1": 20.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 21,
        "score": 41.0000,
        "longevity": 21.0000,
        "gameScore1": 20.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 22,
        "score": 42.0000,
        "longevity": 22.0000,
        "gameScore1": 20.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 23,
        "score": 57.0000,
        "longevity": 23.0000,
        "gameScore1": 34.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 24,
        "score": 58.0000,
        "longevity": 24.0000,
        "gameScore1": 34.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 25,
        "score": 59.0000,
        "longevity": 25.0000,
        "gameScore1": 34.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 26,
        "score": 60.0000,
        "longevity": 26.0000,
        "gameScore1": 34.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 27,
        "score": 72.0000,
        "longevity": 27.0000,
        "gameScore1": 45.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 28,
        "score": 73.0000,
        "longevity": 28.0000,
        "gameScore1": 45.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 29,
        "score": 74.0000,
        "longevity": 29.0000,
        "gameScore1": 45.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 30,
        "score": 75.0000,
        "longevity": 30.0000,
        "gameScore1": 45.0000,
        "gameScore2": 0.0000
      },
        {
          "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
          "entityWebPath": "louana-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 31,
          "score": 76.0000,
          "longevity": 31.0000,
          "gameScore1": 45.0000,
          "gameScore2": 0.0000
        }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 32,
        "score": 76.0000,
        "longevity": 31.0000,
        "gameScore1": 45.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/louana-2022",
        "entityWebPath": "louana-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 33,
        "score": 76.0000,
        "longevity": 31.0000,
        "gameScore1": 45.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 1,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 2,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      },
        {
          "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
          "entityWebPath": "francois-2022",
          "entityTypeWebPath": "player",
          "contextWebPath": "le-totem-maudit",
          "contextTypeWebPath": "programme",
          "day": 3,
          "score": 33.0000,
          "longevity": 33.0000,
          "gameScore1": 0.0000,
          "gameScore2": 0.0000
        }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 4,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 5,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 6,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 7,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 8,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 9,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 10,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 11,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 12,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 13,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 14,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 15,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 16,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 17,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 18,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 19,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 20,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 21,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 22,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 23,
        "score": 33.0000,
        "longevity": 33.0000,
        "gameScore1": 0.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 24,
        "score": 46.0000,
        "longevity": 33.0000,
        "gameScore1": 13.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 25,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 26,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 27,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 28,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 29,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 30,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 31,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 32,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 33,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 34,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 35,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 36,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 37,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 38,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }, {
        "fullWebPath": "programme/le-totem-maudit/player/francois-2022",
        "entityWebPath": "francois-2022",
        "entityTypeWebPath": "player",
        "contextWebPath": "le-totem-maudit",
        "contextTypeWebPath": "programme",
        "day": 39,
        "score": 59.0000,
        "longevity": 33.0000,
        "gameScore1": 26.0000,
        "gameScore2": 0.0000
      }]
  }

import {getTimelineAbscissa, getDatasetsData, getChartJsDatasets} from 'kohlantstats/utils/timeline-utils'

module('Unit | Utility | timeline-utils', function () {

  test('test abscissa', function (assert) {
    let data = scoreTimeline.ScoreTimelineOut;
    let expectedResult = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39];
    let result = getTimelineAbscissa(data);
    assert.ok(result);
    debugger
    assert.deepEqual(result, expectedResult, "The 2 sets should be identical");
  });

  test('test datasets', function (assert) {
    let data = scoreTimeline.ScoreTimelineOut;
    let expectedResult = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39];
    let result = getDatasetsData(data);
    assert.ok(result);
  });


});
