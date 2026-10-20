# Liturgical Calendar API

Liturgical Calendar retrieves Catholic liturgical calendar events for any given month. It details feast ranks, vestment colors, liturgical seasons, and holy days of obligation, while paid plans add custom year queries.

[![npm version](https://img.shields.io/npm/v/@apiverve/liturgicalcalendar.svg)](https://www.npmjs.com/package/@apiverve/liturgicalcalendar)

This is a JavaScript wrapper for the [Liturgical Calendar API](https://apiverve.com/marketplace/liturgicalcalendar?utm_source=npm&utm_medium=referral&utm_content=readme)

---

## Installation

Using npm:
```shell
npm install @apiverve/liturgicalcalendar
```

Using yarn:
```shell
yarn add @apiverve/liturgicalcalendar
```

---

## Configuration

Before using the Liturgical Calendar API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=npm&utm_medium=referral&utm_content=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=npm&utm_medium=referral&utm_content=readme)

The Liturgical Calendar API documentation is found here: [https://docs.apiverve.com/ref/liturgicalcalendar](https://docs.apiverve.com/ref/liturgicalcalendar?utm_source=npm&utm_medium=referral&utm_content=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const liturgicalcalendarAPI = require('@apiverve/liturgicalcalendar');
const api = new liturgicalcalendarAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  month: 2,
  year: 2025
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  month: 2,
  year: 2025
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  month: 2,
  year: 2025
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}
```

---

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "2026-01-01": [
      {
        "id": "mary_mother_of_god",
        "precedence": "GENERAL_SOLEMNITY_3",
        "rank": "SOLEMNITY",
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      }
    ],
    "2026-01-02": [
      {
        "id": "basil_the_great_and_gregory_nazianzen_bishops",
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "christmas_time_january_2",
          "date": "2026-01-02",
          "dateDef": {
            "dateFn": "weekdayBeforeEpiphany",
            "dateArgs": [
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:christmas_time.before_epiphany",
            {
              "day": 2
            }
          ],
          "seasons": [
            "CHRISTMAS_TIME"
          ],
          "periods": [
            "DAYS_BEFORE_EPIPHANY",
            "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD"
          ],
          "colors": [
            "WHITE"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 9,
            "dayOfWeek": 5,
            "nthDayOfWeekInMonth": 1,
            "startOfSeason": "2025-12-25",
            "endOfSeason": "2026-01-11",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "CHRISTMAS_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_1"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2026-01-03": [
      {
        "id": "christmas_time_january_3",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      },
      {
        "id": "most_holy_name_of_jesus",
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "christmas_time_january_3",
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "colors": [
            "WHITE"
          ]
        }
      }
    ],
    "2026-01-04": [
      {
        "id": "second_sunday_after_christmas",
        "precedence": "UNPRIVILEGED_SUNDAY_6",
        "rank": "SUNDAY",
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      }
    ],
    "2026-01-05": [
      {
        "id": "christmas_time_january_5",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      }
    ],
    "2026-01-06": [
      {
        "id": "epiphany_of_the_lord",
        "precedence": "PROPER_OF_TIME_SOLEMNITY_2",
        "rank": "SOLEMNITY",
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      }
    ],
    "2026-01-07": [
      {
        "id": "wednesday_after_epiphany",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      },
      {
        "id": "raymond_of_penyafort_priest",
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "wednesday_after_epiphany",
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "colors": [
            "WHITE"
          ]
        }
      }
    ],
    "2026-01-08": [
      {
        "id": "thursday_after_epiphany",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      }
    ],
    "2026-01-09": [
      {
        "id": "friday_after_epiphany",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      }
    ],
    "2026-01-10": [
      {
        "id": "saturday_after_epiphany",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      }
    ],
    "2026-01-11": [
      {
        "id": "baptism_of_the_lord",
        "precedence": "PROPER_OF_TIME_SOLEMNITY_2",
        "rank": "SOLEMNITY",
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "colors": [
          "WHITE"
        ]
      }
    ],
    "2026-01-12": [
      {
        "id": "ordinary_time_1_monday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-13": [
      {
        "id": "ordinary_time_1_tuesday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      },
      {
        "id": "hilary_of_poitiers_bishop",
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "ordinary_time_1_tuesday",
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "colors": [
            "GREEN"
          ]
        }
      }
    ],
    "2026-01-14": [
      {
        "id": "ordinary_time_1_wednesday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-15": [
      {
        "id": "ordinary_time_1_thursday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-16": [
      {
        "id": "ordinary_time_1_friday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-17": [
      {
        "id": "anthony_of_egypt_abbot",
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "ordinary_time_1_saturday",
          "date": "2026-01-17",
          "dateDef": {
            "dateFn": "dateOfOrdinaryTime",
            "dateArgs": [
              6,
              1
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:ordinary_time.weekday",
            {
              "week": 1,
              "dow": 6
            }
          ],
          "seasons": [
            "ORDINARY_TIME"
          ],
          "periods": [
            "EARLY_ORDINARY_TIME"
          ],
          "colors": [
            "GREEN"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 1,
            "dayOfSeason": 6,
            "dayOfWeek": 6,
            "nthDayOfWeekInMonth": 3,
            "startOfSeason": "2026-01-12",
            "endOfSeason": "2026-11-28",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ORDINARY_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_1"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2026-01-18": [
      {
        "id": "ordinary_time_2_sunday",
        "precedence": "UNPRIVILEGED_SUNDAY_6",
        "rank": "SUNDAY",
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-19": [
      {
        "id": "ordinary_time_2_monday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-20": [
      {
        "id": "ordinary_time_2_tuesday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      },
      {
        "id": "fabian_i_pope",
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "colors": [
          "RED"
        ],
        "weekday": {
          "id": "ordinary_time_2_tuesday",
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "colors": [
            "GREEN"
          ]
        }
      },
      {
        "id": "sebastian_of_milan_martyr",
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "colors": [
          "RED"
        ],
        "weekday": {
          "id": "ordinary_time_2_tuesday",
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "colors": [
            "GREEN"
          ]
        }
      }
    ],
    "2026-01-21": [
      {
        "id": "agnes_of_rome_virgin",
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "RED"
        ],
        "weekday": {
          "id": "ordinary_time_2_wednesday",
          "date": "2026-01-21",
          "dateDef": {
            "dateFn": "dateOfOrdinaryTime",
            "dateArgs": [
              3,
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:ordinary_time.weekday",
            {
              "week": 2,
              "dow": 3
            }
          ],
          "seasons": [
            "ORDINARY_TIME"
          ],
          "periods": [
            "EARLY_ORDINARY_TIME"
          ],
          "colors": [
            "GREEN"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 10,
            "dayOfWeek": 3,
            "nthDayOfWeekInMonth": 3,
            "startOfSeason": "2026-01-12",
            "endOfSeason": "2026-11-28",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ORDINARY_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_2"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2026-01-22": [
      {
        "id": "ordinary_time_2_thursday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      },
      {
        "id": "vincent_of_saragossa_deacon",
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "colors": [
          "RED"
        ],
        "weekday": {
          "id": "ordinary_time_2_thursday",
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "colors": [
            "GREEN"
          ]
        }
      }
    ],
    "2026-01-23": [
      {
        "id": "ordinary_time_2_friday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-24": [
      {
        "id": "francis_de_sales_bishop",
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "ordinary_time_2_saturday",
          "date": "2026-01-24",
          "dateDef": {
            "dateFn": "dateOfOrdinaryTime",
            "dateArgs": [
              6,
              2
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:ordinary_time.weekday",
            {
              "week": 2,
              "dow": 6
            }
          ],
          "seasons": [
            "ORDINARY_TIME"
          ],
          "periods": [
            "EARLY_ORDINARY_TIME"
          ],
          "colors": [
            "GREEN"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 2,
            "dayOfSeason": 13,
            "dayOfWeek": 6,
            "nthDayOfWeekInMonth": 4,
            "startOfSeason": "2026-01-12",
            "endOfSeason": "2026-11-28",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ORDINARY_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_2"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2026-01-25": [
      {
        "id": "sunday_of_the_word_of_god",
        "precedence": "UNPRIVILEGED_SUNDAY_6",
        "rank": "SUNDAY",
        "isHolyDayOfObligation": true,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-26": [
      {
        "id": "timothy_of_ephesus_and_titus_of_crete_bishops",
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "ordinary_time_3_monday",
          "date": "2026-01-26",
          "dateDef": {
            "dateFn": "dateOfOrdinaryTime",
            "dateArgs": [
              1,
              3
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:ordinary_time.weekday",
            {
              "week": 3,
              "dow": 1
            }
          ],
          "seasons": [
            "ORDINARY_TIME"
          ],
          "periods": [
            "EARLY_ORDINARY_TIME"
          ],
          "colors": [
            "GREEN"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 3,
            "dayOfSeason": 15,
            "dayOfWeek": 1,
            "nthDayOfWeekInMonth": 4,
            "startOfSeason": "2026-01-12",
            "endOfSeason": "2026-11-28",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ORDINARY_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_3"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2026-01-27": [
      {
        "id": "ordinary_time_3_tuesday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      },
      {
        "id": "angela_merici_virgin",
        "precedence": "OPTIONAL_MEMORIAL_12",
        "rank": "OPTIONAL_MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": true,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "ordinary_time_3_tuesday",
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "colors": [
            "GREEN"
          ]
        }
      }
    ],
    "2026-01-28": [
      {
        "id": "thomas_aquinas_priest",
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "ordinary_time_3_wednesday",
          "date": "2026-01-28",
          "dateDef": {
            "dateFn": "dateOfOrdinaryTime",
            "dateArgs": [
              3,
              3
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:ordinary_time.weekday",
            {
              "week": 3,
              "dow": 3
            }
          ],
          "seasons": [
            "ORDINARY_TIME"
          ],
          "periods": [
            "EARLY_ORDINARY_TIME"
          ],
          "colors": [
            "GREEN"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 3,
            "dayOfSeason": 17,
            "dayOfWeek": 3,
            "nthDayOfWeekInMonth": 4,
            "startOfSeason": "2026-01-12",
            "endOfSeason": "2026-11-28",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ORDINARY_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_3"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ],
    "2026-01-29": [
      {
        "id": "ordinary_time_3_thursday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-30": [
      {
        "id": "ordinary_time_3_friday",
        "precedence": "WEEKDAY_13",
        "rank": "WEEKDAY",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "GREEN"
        ]
      }
    ],
    "2026-01-31": [
      {
        "id": "john_bosco_priest",
        "precedence": "GENERAL_MEMORIAL_10",
        "rank": "MEMORIAL",
        "isHolyDayOfObligation": false,
        "isOptional": false,
        "colors": [
          "WHITE"
        ],
        "weekday": {
          "id": "ordinary_time_3_saturday",
          "date": "2026-01-31",
          "dateDef": {
            "dateFn": "dateOfOrdinaryTime",
            "dateArgs": [
              6,
              3
            ],
            "yearOffset": 0
          },
          "dateExceptions": [],
          "alternativeTransferDateDefs": [],
          "precedence": "WEEKDAY_13",
          "rank": "WEEKDAY",
          "allowSimilarRankItems": false,
          "isHolyDayOfObligation": false,
          "isOptional": false,
          "i18nDef": [
            "seasons:ordinary_time.weekday",
            {
              "week": 3,
              "dow": 6
            }
          ],
          "seasons": [
            "ORDINARY_TIME"
          ],
          "periods": [
            "EARLY_ORDINARY_TIME"
          ],
          "colors": [
            "GREEN"
          ],
          "commonsDef": [],
          "martyrology": [],
          "titles": [],
          "calendar": {
            "weekOfSeason": 3,
            "dayOfSeason": 20,
            "dayOfWeek": 6,
            "nthDayOfWeekInMonth": 5,
            "startOfSeason": "2026-01-12",
            "endOfSeason": "2026-11-28",
            "startOfLiturgicalYear": "2025-11-30",
            "endOfLiturgicalYear": "2026-11-28",
            "seasons": [
              "ORDINARY_TIME"
            ]
          },
          "cycles": {
            "properCycle": "PROPER_OF_TIME",
            "sundayCycle": "YEAR_A",
            "weekdayCycle": "YEAR_2",
            "psalterWeek": "WEEK_3"
          },
          "fromCalendarId": "ProperOfTime",
          "fromExtendedCalendars": []
        }
      }
    ]
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=npm&utm_medium=referral&utm_content=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=npm&utm_medium=referral&utm_content=readme) and [Privacy Policy](https://apiverve.com/privacy?utm_source=npm&utm_medium=referral&utm_content=readme).

---

## License
Licensed under the MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
