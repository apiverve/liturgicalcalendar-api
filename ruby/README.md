# Liturgical Calendar API - Ruby Gem

Liturgical Calendar retrieves Catholic liturgical calendar events for any given month. It details feast ranks, vestment colors, liturgical seasons, and holy days of obligation, while paid plans add custom year queries.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_liturgicalcalendar'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_liturgicalcalendar
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_liturgicalcalendar'

# Initialize the client
client = APIVerve::Liturgicalcalendar::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  month: 2,
  year: 2025
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ month: 2, year: 2025 })
  puts response["data"]
rescue APIVerve::Liturgicalcalendar::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Liturgicalcalendar::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Liturgicalcalendar::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/liturgicalcalendar?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/liturgicalcalendar?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/liturgicalcalendar?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
