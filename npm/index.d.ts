declare module '@apiverve/liturgicalcalendar' {
  export interface liturgicalcalendarOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface liturgicalcalendarResponse {
    status: string;
    error: string | null;
    data: LiturgicalCalendarData;
    code?: number;
  }


  interface LiturgicalCalendarData {
      the20250301: The20250301[];
      the20250302: The20250302[];
      the20250303: The20250301[];
      the20250304: The20250304[];
      the20250305: The20250305[];
      the20250306: The20250306[];
      the20250307: The2025030[];
      the20250308: The2025030[];
      the20250309: The202503[];
      the20250310: The20250310[];
      the20250311: The20250310[];
      the20250312: The20250310[];
      the20250313: The20250310[];
      the20250314: The20250310[];
      the20250315: The20250310[];
      the20250316: The202503[];
      the20250317: The2025031[];
      the20250318: The2025031[];
      the20250319: The20250319[];
      the20250320: The20250310[];
      the20250321: The20250310[];
      the20250322: The20250310[];
      the20250323: The202503[];
      the20250324: The20250310[];
      the20250325: The20250325[];
      the20250326: The20250310[];
      the20250327: The20250310[];
      the20250328: The20250310[];
      the20250329: The20250310[];
      the20250330: The202503[];
      the20250331: The20250310[];
  }
  
  interface The20250301 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250301_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        Rank;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     The20250301_I18NDef[];
      seasons:                     Season[];
      periods:                     string[];
      colors:                      string[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID;
      fromExtendedCalendars:       any[];
  }
  
  interface Calendar {
      weekOfSeason:          number;
      dayOfSeason:           number;
      dayOfWeek:             number;
      nthDayOfWeekInMonth:   number;
      startOfSeason:         Date;
      endOfSeason:           Date;
      startOfLiturgicalYear: Date;
      endOfLiturgicalYear:   Date;
      seasons:               Season[];
  }
  
  enum Season {
      Lent = "LENT",
      OrdinaryTime = "ORDINARY_TIME",
  }
  
  interface Cycles {
      properCycle:  ProperCycle;
      sundayCycle:  SundayCycle;
      weekdayCycle: WeekdayCycle;
      psalterWeek:  PsalterWeek;
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
      YearC = "YEAR_C",
  }
  
  enum WeekdayCycle {
      Year1 = "YEAR_1",
  }
  
  interface The20250301_DateDef {
      dateFn:     string;
      dateArgs:   number[];
      yearOffset: number;
  }
  
  enum FromCalendarID {
      ProperOfTime = "ProperOfTime",
  }
  
  type The20250301_I18NDef = PurpleI18NDef | string;
  
  interface PurpleI18NDef {
      week: number;
      dow:  number;
  }
  
  enum Rank {
      Weekday = "WEEKDAY",
  }
  
  interface The20250302 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250301_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        string;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     The20250302_I18NDef[];
      seasons:                     Season[];
      periods:                     string[];
      colors:                      string[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID;
      fromExtendedCalendars:       any[];
  }
  
  type The20250302_I18NDef = FluffyI18NDef | string;
  
  interface FluffyI18NDef {
      week: number;
  }
  
  interface The20250304 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250304_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        string;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     The20250301_I18NDef[];
      seasons:                     Season[];
      periods:                     string[];
      colors:                      string[];
      commonsDef:                  string[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              string;
      fromExtendedCalendars:       any[];
      weekday?:                    The20250301;
  }
  
  interface The20250304_DateDef {
      dateFn?:     string;
      dateArgs?:   number[];
      yearOffset?: number;
      month?:      number;
      date?:       number;
      addDay?:     number;
  }
  
  interface The20250305 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250305_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        Rank;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     string[];
      seasons:                     Season[];
      periods:                     Period[];
      colors:                      Color[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID;
      fromExtendedCalendars:       any[];
  }
  
  enum Color {
      Purple = "PURPLE",
  }
  
  interface The20250305_DateDef {
      dateFn:     DateFn;
      yearOffset: number;
  }
  
  enum DateFn {
      AshWednesday = "ashWednesday",
  }
  
  enum Period {
      PresentationOfTheLordToHolyThursday = "PRESENTATION_OF_THE_LORD_TO_HOLY_THURSDAY",
  }
  
  interface The20250306 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250306_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  Precedence;
      rank:                        Rank;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     The20250306_I18NDef[];
      seasons:                     Season[];
      periods:                     Period[];
      colors:                      Color[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID;
      fromExtendedCalendars:       any[];
  }
  
  interface The20250306_DateDef {
      dateFn:     DateFn;
      addDay:     number;
      yearOffset: number;
  }
  
  type The20250306_I18NDef = TentacledI18NDef | string;
  
  interface TentacledI18NDef {
      dow: number;
  }
  
  enum Precedence {
      PrivilegedWeekday9 = "PRIVILEGED_WEEKDAY_9",
  }
  
  interface The2025030 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250304_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        string;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     The20250306_I18NDef[];
      seasons:                     Season[];
      periods:                     Period[];
      colors:                      Color[];
      commonsDef:                  string[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              string;
      fromExtendedCalendars:       any[];
      weekday?:                    The20250306;
  }
  
  interface The202503 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250306_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        string;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     The20250302_I18NDef[];
      seasons:                     Season[];
      periods:                     Period[];
      colors:                      string[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID;
      fromExtendedCalendars:       any[];
  }
  
  interface The20250310 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250306_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  Precedence;
      rank:                        Rank;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     The20250310_I18NDef[];
      seasons:                     Season[];
      periods:                     Period[];
      colors:                      Color[];
      commonsDef:                  any[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              FromCalendarID;
      fromExtendedCalendars:       any[];
  }
  
  type The20250310_I18NDef = PurpleI18NDef | I18NDefEnum;
  
  enum I18NDefEnum {
      SeasonsLentWeekday = "seasons:lent.weekday",
  }
  
  interface The2025031 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250304_DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        string;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     The20250301_I18NDef[];
      seasons:                     Season[];
      periods:                     Period[];
      colors:                      Color[];
      commonsDef:                  string[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              string;
      fromExtendedCalendars:       any[];
      weekday?:                    The20250310;
  }
  
  interface The20250319 {
      id:                          string;
      date:                        Date;
      dateDef:                     The20250319_DateDef;
      dateExceptions:              DateException[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        string;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     string[];
      seasons:                     Season[];
      periods:                     Period[];
      colors:                      string[];
      commonsDef:                  string[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              string;
      fromExtendedCalendars:       any[];
  }
  
  interface The20250319_DateDef {
      month: number;
      date:  number;
  }
  
  interface DateException {
      ifIsDayOfWeek?: number;
      setDate:        SetDate;
      ifIsBetween?:   IfIsBetween;
  }
  
  interface IfIsBetween {
      from:      DateDef;
      to:        DateDef;
      inclusive: boolean;
  }
  
  interface DateDef {
      dateFn: string;
  }
  
  interface SetDate {
      addDay?:      number;
      dateFn?:      string;
      subtractDay?: number;
  }
  
  interface The20250325 {
      id:                          string;
      date:                        Date;
      dateDef:                     DateDef;
      dateExceptions:              any[];
      alternativeTransferDateDefs: any[];
      precedence:                  string;
      rank:                        string;
      allowSimilarRankItems:       boolean;
      isHolyDayOfObligation:       boolean;
      isOptional:                  boolean;
      i18NDef:                     string[];
      seasons:                     Season[];
      periods:                     Period[];
      colors:                      string[];
      commonsDef:                  string[];
      martyrology:                 any[];
      titles:                      any[];
      calendar:                    Calendar;
      cycles:                      Cycles;
      fromCalendarID:              string;
      fromExtendedCalendars:       any[];
  }

  export default class liturgicalcalendarWrapper {
    constructor(options: liturgicalcalendarOptions);

    execute(callback: (error: any, data: liturgicalcalendarResponse | null) => void): Promise<liturgicalcalendarResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: liturgicalcalendarResponse | null) => void): Promise<liturgicalcalendarResponse>;
    execute(query?: Record<string, any>): Promise<liturgicalcalendarResponse>;
  }
}
