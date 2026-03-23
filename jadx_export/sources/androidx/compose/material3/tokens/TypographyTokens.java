package androidx.compose.material3.tokens;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.GenericFontFamily;
import kotlin.Metadata;

/* compiled from: TypographyTokens.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", "()V", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypographyTokens {
    public static final int $stable = 0;
    private static final TextStyle BodyLarge;
    private static final TextStyle BodyMedium;
    private static final TextStyle BodySmall;
    private static final TextStyle DisplayLarge;
    private static final TextStyle DisplayMedium;
    private static final TextStyle DisplaySmall;
    private static final TextStyle HeadlineLarge;
    private static final TextStyle HeadlineMedium;
    private static final TextStyle HeadlineSmall;
    public static final TypographyTokens INSTANCE = new TypographyTokens();
    private static final TextStyle LabelLarge;
    private static final TextStyle LabelMedium;
    private static final TextStyle LabelSmall;
    private static final TextStyle TitleLarge;
    private static final TextStyle TitleMedium;
    private static final TextStyle TitleSmall;

    private TypographyTokens() {
    }

    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    static {
        TextStyle defaultTextStyle = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyLargeFont = TypeScaleTokens.INSTANCE.getBodyLargeFont();
        BodyLarge = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle, 0L, TypeScaleTokens.INSTANCE.m3589getBodyLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyLargeWeight(), null, null, bodyLargeFont, null, TypeScaleTokens.INSTANCE.m3590getBodyLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3588getBodyLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle2 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyMediumFont = TypeScaleTokens.INSTANCE.getBodyMediumFont();
        BodyMedium = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle2, 0L, TypeScaleTokens.INSTANCE.m3592getBodyMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyMediumWeight(), null, null, bodyMediumFont, null, TypeScaleTokens.INSTANCE.m3593getBodyMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3591getBodyMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle3 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodySmallFont = TypeScaleTokens.INSTANCE.getBodySmallFont();
        BodySmall = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle3, 0L, TypeScaleTokens.INSTANCE.m3595getBodySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodySmallWeight(), null, null, bodySmallFont, null, TypeScaleTokens.INSTANCE.m3596getBodySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3594getBodySmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle4 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayLargeFont = TypeScaleTokens.INSTANCE.getDisplayLargeFont();
        DisplayLarge = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle4, 0L, TypeScaleTokens.INSTANCE.m3598getDisplayLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayLargeWeight(), null, null, displayLargeFont, null, TypeScaleTokens.INSTANCE.m3599getDisplayLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3597getDisplayLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle5 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayMediumFont = TypeScaleTokens.INSTANCE.getDisplayMediumFont();
        DisplayMedium = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle5, 0L, TypeScaleTokens.INSTANCE.m3601getDisplayMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayMediumWeight(), null, null, displayMediumFont, null, TypeScaleTokens.INSTANCE.m3602getDisplayMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3600getDisplayMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle6 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displaySmallFont = TypeScaleTokens.INSTANCE.getDisplaySmallFont();
        DisplaySmall = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle6, 0L, TypeScaleTokens.INSTANCE.m3604getDisplaySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplaySmallWeight(), null, null, displaySmallFont, null, TypeScaleTokens.INSTANCE.m3605getDisplaySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3603getDisplaySmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle7 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineLargeFont = TypeScaleTokens.INSTANCE.getHeadlineLargeFont();
        HeadlineLarge = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle7, 0L, TypeScaleTokens.INSTANCE.m3607getHeadlineLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineLargeWeight(), null, null, headlineLargeFont, null, TypeScaleTokens.INSTANCE.m3608getHeadlineLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3606getHeadlineLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle8 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineMediumFont = TypeScaleTokens.INSTANCE.getHeadlineMediumFont();
        HeadlineMedium = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle8, 0L, TypeScaleTokens.INSTANCE.m3610getHeadlineMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineMediumWeight(), null, null, headlineMediumFont, null, TypeScaleTokens.INSTANCE.m3611getHeadlineMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3609getHeadlineMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle9 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineSmallFont = TypeScaleTokens.INSTANCE.getHeadlineSmallFont();
        HeadlineSmall = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle9, 0L, TypeScaleTokens.INSTANCE.m3613getHeadlineSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineSmallWeight(), null, null, headlineSmallFont, null, TypeScaleTokens.INSTANCE.m3614getHeadlineSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3612getHeadlineSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle10 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelLargeFont = TypeScaleTokens.INSTANCE.getLabelLargeFont();
        LabelLarge = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle10, 0L, TypeScaleTokens.INSTANCE.m3616getLabelLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelLargeWeight(), null, null, labelLargeFont, null, TypeScaleTokens.INSTANCE.m3617getLabelLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3615getLabelLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle11 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelMediumFont = TypeScaleTokens.INSTANCE.getLabelMediumFont();
        LabelMedium = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle11, 0L, TypeScaleTokens.INSTANCE.m3619getLabelMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelMediumWeight(), null, null, labelMediumFont, null, TypeScaleTokens.INSTANCE.m3620getLabelMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3618getLabelMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle12 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelSmallFont = TypeScaleTokens.INSTANCE.getLabelSmallFont();
        LabelSmall = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle12, 0L, TypeScaleTokens.INSTANCE.m3622getLabelSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelSmallWeight(), null, null, labelSmallFont, null, TypeScaleTokens.INSTANCE.m3623getLabelSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3621getLabelSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle13 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleLargeFont = TypeScaleTokens.INSTANCE.getTitleLargeFont();
        TitleLarge = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle13, 0L, TypeScaleTokens.INSTANCE.m3625getTitleLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleLargeWeight(), null, null, titleLargeFont, null, TypeScaleTokens.INSTANCE.m3626getTitleLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3624getTitleLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle14 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleMediumFont = TypeScaleTokens.INSTANCE.getTitleMediumFont();
        TitleMedium = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle14, 0L, TypeScaleTokens.INSTANCE.m3628getTitleMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleMediumWeight(), null, null, titleMediumFont, null, TypeScaleTokens.INSTANCE.m3629getTitleMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3627getTitleMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle15 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleSmallFont = TypeScaleTokens.INSTANCE.getTitleSmallFont();
        TitleSmall = TextStyle.m6159copyp1EtxEg$default(defaultTextStyle15, 0L, TypeScaleTokens.INSTANCE.m3631getTitleSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleSmallWeight(), null, null, titleSmallFont, null, TypeScaleTokens.INSTANCE.m3632getTitleSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m3630getTitleSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
    }

    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }
}
