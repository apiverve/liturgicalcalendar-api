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
      id:                    null | string;
      precedence:            Precedence | null;
      rank:                  Rank | null;
      isHolyDayOfObligation: boolean | null;
      isOptional:            boolean | null;
      colors:                (Color | null)[];
      weekday?:              Weekday;
  }
  
  enum Color {
      Green = "GREEN",
      Red = "RED",
      White = "WHITE",
  }
  
  enum Precedence {
      GeneralMemorial10 = "GENERAL_MEMORIAL_10",
      GeneralSolemnity3 = "GENERAL_SOLEMNITY_3",
      OptionalMemorial12 = "OPTIONAL_MEMORIAL_12",
      ProperOfTimeSolemnity2 = "PROPER_OF_TIME_SOLEMNITY_2",
      UnprivilegedSunday6 = "UNPRIVILEGED_SUNDAY_6",
      Weekday13 = "WEEKDAY_13",
  }
  
  enum Rank {
      Memorial = "MEMORIAL",
      OptionalMemorial = "OPTIONAL_MEMORIAL",
      Solemnity = "SOLEMNITY",
      Sunday = "SUNDAY",
      Weekday = "WEEKDAY",
  }
  
  interface Weekday {
      id:                           null | string;
      date?:                        Date | null;
      dateDef?:                     DateDef;
      dateExceptions?:              any[];
      alternativeTransferDateDefs?: any[];
      precedence:                   Precedence | null;
      rank:                         Rank | null;
      allowSimilarRankItems?:       boolean | null;
      isHolyDayOfObligation:        boolean | null;
      isOptional:                   boolean | null;
      i18NDef?:                     I18NDefElement[];
      seasons?:                     (null | string)[];
      periods?:                     (null | string)[];
      colors:                       (Color | null)[];
      commonsDef?:                  any[];
      martyrology?:                 any[];
      titles?:                      any[];
      calendar?:                    Calendar;
      cycles?:                      Cycles;
      fromCalendarID?:              null | string;
      fromExtendedCalendars?:       any[];
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
      seasons:               (null | string)[];
  }
  
  interface Cycles {
      properCycle:  null | string;
      sundayCycle:  null | string;
      weekdayCycle: null | string;
      psalterWeek:  null | string;
  }
  
  interface DateDef {
      dateFn:     null | string;
      dateArgs:   (number | null)[];
      yearOffset: number | null;
  }
  
  type I18NDefElement = I18NDefClass | null | string;
  
  interface I18NDefClass {
      day?:  number | null;
      week?: number | null;
      dow?:  number | null;
  }

  export default class liturgicalcalendarWrapper {
    constructor(options: liturgicalcalendarOptions);

    execute(callback: (error: any, data: liturgicalcalendarResponse | null) => void): Promise<liturgicalcalendarResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: liturgicalcalendarResponse | null) => void): Promise<liturgicalcalendarResponse>;
    execute(query?: Record<string, any>): Promise<liturgicalcalendarResponse>;
  }
}
