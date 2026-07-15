declare module '@apiverve/liturgicalcalendar' {
  export interface liturgicalcalendarOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface liturgicalcalendarResponse {
    status: string;
    error: string | null;
    data: LiturgicalCalendarData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface LiturgicalCalendarData {
      the20251201: The20251201[];
      the20251202: The20251201[];
      the20251203: The20251203_Element[];
      the20251204: The20251204_Element[];
      the20251205: The20251201[];
      the20251206: The20251204_Element[];
      the20251207: The20251207_Element[];
      the20251208: The20251208[];
      the20251209: The20251204_Element[];
      the20251210: The20251204_Element[];
      the20251211: The20251204_Element[];
      the20251212: The20251204_Element[];
      the20251213: The20251203_Element[];
      the20251214: The20251207_Element[];
      the20251215: The20251201[];
      the20251216: The20251201[];
      the20251217: The20251217[];
      the20251218: The20251217[];
      the20251219: The20251217[];
      the20251220: The20251217[];
      the20251221: The20251207_Element[];
      the20251222: The20251217[];
      the20251223: The20251223[];
      the20251224: The20251217[];
      the20251225: The20251225_Element[];
      the20251226: The20251226_Element[];
      the20251227: The20251226_Element[];
      the20251228: The20251225_Element[];
      the20251229: The20251229_Element[];
      the20251230: The20251230[];
      the20251231: The20251229_Element[];
  }
  
  interface The20251201 {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251201_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  Precedence | null;
      rank:                        Rank | null;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     The20251201_I18NDef[];
      seasons:                     (Season | null)[];
      periods:                     any[];
      colors:                      (Color | null)[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
  }
  
  interface Calendar {
      weekOfSeason:          number | null;
      dayOfSeason:           number | null;
      dayOfWeek:             number | null;
      nthDayOfWeekInMonth:   number | null;
      startOfSeason:         Date | null;
      endOfSeason:           Date | null;
      startOfLiturgicalYear: Date | null;
      endOfLiturgicalYear:   Date | null;
      seasons:               (Season | null)[];
  }
  
  enum Season {
      Advent = "ADVENT",
      ChristmasTime = "CHRISTMAS_TIME",
  }
  
  enum Color {
      Purple = "PURPLE",
      White = "WHITE",
  }
  
  interface Cycles {
      properCycle:  ProperCycle | null;
      sundayCycle:  SundayCycle | null;
      weekdayCycle: WeekdayCycle | null;
      psalterWeek:  PsalterWeek | null;
  }
  
  enum ProperCycle {
      ProperOfSaints = "PROPER_OF_SAINTS",
      ProperOfTime = "PROPER_OF_TIME",
  }
  
  enum PsalterWeek {
      Week1 = "WEEK_1",
      Week2 = "WEEK_2",
      Week3 = "WEEK_3",
      Week4 = "WEEK_4",
  }
  
  enum SundayCycle {
      YearA = "YEAR_A",
  }
  
  enum WeekdayCycle {
      Year2 = "YEAR_2",
  }
  
  interface The20251201_DateDef {
      dateFn:     DateFn | null;
      dateArgs:   (number | null)[];
      yearOffset: number | null;
  }
  
  enum DateFn {
      PrivilegedWeekdayOfAdvent = "privilegedWeekdayOfAdvent",
      SundayOfAdvent = "sundayOfAdvent",
      UnprivilegedWeekdayOfAdvent = "unprivilegedWeekdayOfAdvent",
      WeekdayWithinOctaveOfChristmas = "weekdayWithinOctaveOfChristmas",
  }
  
  enum FromCalendarID {
      Ma = "ma",
      ProperOfTime = "ProperOfTime",
  }
  
  type The20251201_I18NDef = PurpleI18NDef | I18NDefEnum | null;
  
  interface PurpleI18NDef {
      week: number | null;
      dow:  number | null;
  }
  
  enum I18NDefEnum {
      SeasonsAdventWeekday = "seasons:advent.weekday",
  }
  
  enum Precedence {
      OptionalMemorial12 = "OPTIONAL_MEMORIAL_12",
      Weekday13 = "WEEKDAY_13",
  }
  
  enum Rank {
      OptionalMemorial = "OPTIONAL_MEMORIAL",
      Weekday = "WEEKDAY",
  }
  
  interface The20251203_Element {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251203_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        null | string;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     (null | string)[];
      seasons:                     (Season | null)[];
      periods:                     any[];
      colors:                      (null | string)[];
      commonsDef:                  (null | string)[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
      weekday:                     The20251201;
  }
  
  interface The20251203_DateDef {
      month: number | null;
      date:  number | null;
  }
  
  interface The20251204_Element {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251204_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  Precedence | null;
      rank:                        Rank | null;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     The20251204_I18NDef[];
      seasons:                     (Season | null)[];
      periods:                     any[];
      colors:                      (Color | null)[];
      commonsDef:                  (null | string)[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
      weekday?:                    The20251201;
  }
  
  interface The20251204_DateDef {
      dateFn?:     DateFn | null;
      dateArgs?:   (number | null)[];
      yearOffset?: number | null;
      month?:      number | null;
      date?:       number | null;
  }
  
  type The20251204_I18NDef = PurpleI18NDef | null | string;
  
  interface The20251207_Element {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251201_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        null | string;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     The20251207_I18NDef[];
      seasons:                     (Season | null)[];
      periods:                     any[];
      colors:                      (null | string)[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
  }
  
  type The20251207_I18NDef = FluffyI18NDef | null | string;
  
  interface FluffyI18NDef {
      week: number | null;
  }
  
  interface The20251208 {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251208_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        null | string;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     (null | string)[];
      seasons:                     (Season | null)[];
      periods:                     any[];
      colors:                      (Color | null)[];
      commonsDef:                  (null | string)[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
  }
  
  interface The20251208_DateDef {
      dateFn: null | string;
  }
  
  interface The20251217 {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251201_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        Rank | null;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     The20251217_I18NDef[];
      seasons:                     (Season | null)[];
      periods:                     any[];
      colors:                      (Color | null)[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
  }
  
  type The20251217_I18NDef = TentacledI18NDef | null | string;
  
  interface TentacledI18NDef {
      day: number | null;
  }
  
  interface The20251223 {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251204_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        Rank | null;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     The20251217_I18NDef[];
      seasons:                     (Season | null)[];
      periods:                     any[];
      colors:                      (Color | null)[];
      commonsDef:                  (null | string)[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
      weekday?:                    The20251217;
  }
  
  interface The20251225_Element {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251225_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        null | string;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     (null | string)[];
      seasons:                     (Season | null)[];
      periods:                     (Period | null)[];
      colors:                      (Color | null)[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
  }
  
  interface The20251225_DateDef {
      dateFn:     null | string;
      yearOffset: number | null;
  }
  
  enum Period {
      ChristmasOctave = "CHRISTMAS_OCTAVE",
      ChristmasToPresentationOfTheLord = "CHRISTMAS_TO_PRESENTATION_OF_THE_LORD",
  }
  
  interface The20251226_Element {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251203_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        null | string;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     (null | string)[];
      seasons:                     (Season | null)[];
      periods:                     (Period | null)[];
      colors:                      (null | string)[];
      commonsDef:                  (null | string)[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
      weekday:                     The20251230;
  }
  
  interface The20251230 {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251201_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        Rank | null;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     The20251230_I18NDef[];
      seasons:                     (Season | null)[];
      periods:                     (Period | null)[];
      colors:                      (Color | null)[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
  }
  
  type The20251230_I18NDef = StickyI18NDef | null | string;
  
  interface StickyI18NDef {
      count: number | null;
  }
  
  interface The20251229_Element {
      id:                          null | string;
      date:                        Date | null;
      dateDef:                     The20251204_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  null | string;
      rank:                        Rank | null;
      allowSimilarRankItems:       boolean | null;
      isHolyDayOfObligation:       boolean | null;
      isOptional:                  boolean | null;
      i18NDef:                     The20251230_I18NDef[];
      seasons:                     (Season | null)[];
      periods:                     (Period | null)[];
      colors:                      (Color | null)[];
      commonsDef:                  (null | string)[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID | null;
      fromExtendedCalendars:       any[];
      weekday?:                    The20251230;
  }

  export default class liturgicalcalendarWrapper {
    constructor(options: liturgicalcalendarOptions);

    execute(callback: (error: any, data: liturgicalcalendarResponse | null) => void): Promise<liturgicalcalendarResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: liturgicalcalendarResponse | null) => void): Promise<liturgicalcalendarResponse>;
    execute(query?: Record<string, any>): Promise<liturgicalcalendarResponse>;
  }
}
