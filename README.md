# [Liturgical Calendar API](https://apiverve.com/marketplace/liturgicalcalendar?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)

Liturgical Calendar retrieves Catholic liturgical calendar events for any given month. It details feast ranks, vestment colors, liturgical seasons, and holy days of obligation, while paid plans add custom year queries.

The Liturgical Calendar API provides a simple, reliable way to integrate liturgical calendar functionality into your applications. Built for developers who need production-ready liturgical calendar capabilities without the complexity of building from scratch.

**[View API Details →](https://apiverve.com/marketplace/liturgicalcalendar?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)**

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![API Status](https://img.shields.io/badge/Status-Active-green.svg)](https://apiverve.com/marketplace/liturgicalcalendar?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
[![Method](https://img.shields.io/badge/Method-GET-blue.svg)](#)
[![Platform](https://img.shields.io/badge/Platform-Multi--Platform-orange.svg)](#installation)

**Available on:**
[![npm](https://img.shields.io/badge/npm-CB3837?style=flat&logo=npm&logoColor=white)](https://www.npmjs.com/package/@apiverve/liturgicalcalendar)
[![NuGet](https://img.shields.io/badge/NuGet-004880?style=flat&logo=nuget&logoColor=white)](https://www.nuget.org/packages/APIVerve.API.LiturgicalCalendar)
[![PyPI](https://img.shields.io/badge/PyPI-3776AB?style=flat&logo=python&logoColor=white)](https://pypi.org/project/apiverve-liturgicalcalendar/)
[![RubyGems](https://img.shields.io/badge/RubyGems-E9573F?style=flat&logo=rubygems&logoColor=white)](https://rubygems.org/gems/apiverve_liturgicalcalendar)
[![Packagist](https://img.shields.io/badge/Packagist-F28D1A?style=flat&logo=packagist&logoColor=white)](https://packagist.org/packages/apiverve/liturgicalcalendar)
[![Go](https://img.shields.io/badge/Go-00ADD8?style=flat&logo=go&logoColor=white)](#-go)
[![Dart](https://img.shields.io/badge/Dart-0175C2?style=flat&logo=dart&logoColor=white)](https://pub.dev/packages/apiverve_liturgicalcalendar)
[![JitPack](https://img.shields.io/badge/JitPack-2E7D32?style=flat&logo=android&logoColor=white)](#-android-jitpack)

---

## Quick Start

### Using JavaScript

```javascript
async function callLiturgicalCalendarAPI() {
    try {
        const params = new URLSearchParams({
            month: 2
        });

        const response = await fetch(`https://api.apiverve.com/v1/liturgicalcalendar?${params}`, {
            method: 'GET',
            headers: {
                'x-api-key': 'YOUR_API_KEY_HERE'
            }
        });

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error('Error:', error);
    }
}

callLiturgicalCalendarAPI();
```

### Using cURL

```bash
curl -X GET "https://api.apiverve.com/v1/liturgicalcalendar?month=2" \
  -H "x-api-key: YOUR_API_KEY_HERE"
```

**Get your API key:** [https://apiverve.com](https://apiverve.com)

**📁 For more examples, see the [examples folder](./examples/)**

---

## Installation

Choose your preferred programming language:

### 📦 NPM (JavaScript/Node.js)

```bash
npm install @apiverve/liturgicalcalendar
```

[**View NPM Package →**](https://www.npmjs.com/package/@apiverve/liturgicalcalendar) | [**Package Code →**](./npm/)

---

### 🔷 NuGet (.NET/C#)

```bash
dotnet add package APIVerve.API.LiturgicalCalendar
```

[**View NuGet Package →**](https://www.nuget.org/packages/APIVerve.API.LiturgicalCalendar) | [**Package Code →**](./nuget/)

---

### 🐍 Python (PyPI)

```bash
pip install apiverve-liturgicalcalendar
```

[**View PyPI Package →**](https://pypi.org/project/apiverve-liturgicalcalendar/) | [**Package Code →**](./python/)

---

### 💎 Ruby (RubyGems)

```bash
gem install apiverve_liturgicalcalendar
```

[**View RubyGems Package →**](https://rubygems.org/gems/apiverve_liturgicalcalendar) | [**Package Code →**](./ruby/)

---

### 🐘 PHP (Packagist)

```bash
composer require apiverve/liturgicalcalendar
```

[**View Packagist Package →**](https://packagist.org/packages/apiverve/liturgicalcalendar) | [**Package Code →**](./php/)

---

### 🎯 Dart (pub.dev)

```bash
dart pub add apiverve_liturgicalcalendar
```

[**View pub.dev Package →**](https://pub.dev/packages/apiverve_liturgicalcalendar) | [**Package Code →**](./dart/)

---

### 🤖 Android (JitPack)

```gradle
implementation 'com.github.apiverve:liturgicalcalendar-api:1.0.0'
```

[**Package Code →**](./android/)

---

### 🐹 Go

```bash
go get github.com/apiverve/liturgicalcalendar-api/go
```

[**Package Code →**](./go/)

---

## Why Use This API?

| Feature | Benefit |
|---------|---------|
| **Multi-language SDKs** | Native packages for JavaScript, Python, C#, Go, and Android |
| **Simple Integration** | Single API key authentication, consistent response format |
| **Production Ready** | 99.9% uptime SLA, served from 24 global regions |
| **Comprehensive Docs** | Full examples, OpenAPI spec, and dedicated support |

---

## Documentation

- 🏠 **API Home:** [Liturgical Calendar API](https://apiverve.com/marketplace/liturgicalcalendar?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
- 📚 **API Reference:** [docs.apiverve.com/ref/liturgicalcalendar](https://docs.apiverve.com/ref/liturgicalcalendar)
- 📖 **OpenAPI Spec:** [openapi.yaml](./openapi.yaml)
- 💡 **Examples:** [examples/](./examples/)

---

## What Can You Build?

The Liturgical Calendar API is commonly used for:

- **Web Applications** - Add liturgical calendar features to your frontend or backend
- **Mobile Apps** - Native SDKs for Android development
- **Automation** - Integrate with n8n, Zapier, or custom workflows
- **SaaS Products** - Enhance your product with liturgical calendar capabilities
- **Data Pipelines** - Process and analyze data at scale

---

## API Reference

### Authentication
All requests require an API key in the header:
```
x-api-key: YOUR_API_KEY_HERE
```

Get your API key: [https://apiverve.com](https://apiverve.com)

### Response Format

Every APIVerve endpoint returns the same envelope — check `status`, then read `data`:

```json
{
  "status": "ok",
  "error": null,
  "data": { ... }
}
```

### Example Response

A real response from the Liturgical Calendar API:

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

## Support & Community

- 🏠 **API Home**: [Liturgical Calendar API](https://apiverve.com/marketplace/liturgicalcalendar?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
- 💬 **Support**: [https://apiverve.com/contact](https://apiverve.com/contact)
- 🐛 **Issues**: [GitHub Issues](../../issues)
- 📖 **Documentation**: [https://docs.apiverve.com](https://docs.apiverve.com)
- 🌐 **Website**: [https://apiverve.com](https://apiverve.com)

---

## Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

---

## Security

For security concerns, please review our [Security Policy](SECURITY.md).

---

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

Built with ❤️ by [APIVerve](https://apiverve.com)

Copyright © 2026 APIVerve. All rights reserved.
