package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Icon.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000f\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6693constructorimpl(24));

    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1587Iconww6aTOc(ImageVector imageVector, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        long tint2;
        ComposerKt.sourceInformationMarkerStart($composer, -800853103, "C(Icon)P(1!,3:c#ui.graphics.Color)65@3149L7,65@3188L7,68@3229L34,67@3205L163:Icon.kt#jmzs0o");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 8) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM4197unboximpl = ((Color) objConsume).m4197unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            tint2 = Color.m4185copywmQWz5c(jM4197unboximpl, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM4197unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4193getRedimpl(jM4197unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM4197unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM4197unboximpl) : 0.0f);
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-800853103, $changed, -1, "androidx.compose.material.Icon (Icon.kt:66)");
        }
        m1586Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, $composer, $changed & 14), contentDescription, modifier2, tint2, $composer, ($changed & 7168) | VectorPainter.$stable | ($changed & 112) | ($changed & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1585Iconww6aTOc(ImageBitmap bitmap, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        long tint2;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -554892675, "C(Icon)P(!,3:c#ui.graphics.Color)99@4800L7,99@4839L7,101@4870L42,102@4917L136:Icon.kt#jmzs0o");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 8) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM4197unboximpl = ((Color) objConsume).m4197unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            tint2 = Color.m4185copywmQWz5c(jM4197unboximpl, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM4197unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4193getRedimpl(jM4197unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM4197unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM4197unboximpl) : 0.0f);
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554892675, $changed, -1, "androidx.compose.material.Icon (Icon.kt:100)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 724306569, "CC(remember):Icon.kt#9igjgp");
        boolean invalid$iv = $composer.changed(bitmap);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new BitmapPainter(bitmap, 0L, 0L, 6, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        BitmapPainter painter = (BitmapPainter) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        m1586Iconww6aTOc(painter, contentDescription, modifier2, tint2, $composer, ($changed & 7168) | ($changed & 112) | ($changed & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1586Iconww6aTOc(final Painter painter, final String contentDescription, Modifier modifier, long tint, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long tint2;
        Modifier modifier3;
        ColorFilter colorFilter;
        Modifier.Companion companionSemantics$default;
        final Modifier modifier4;
        final long tint3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1142959010);
        ComposerKt.sourceInformation($composer2, "C(Icon)P(2!,3:c#ui.graphics.Color)133@6456L7,133@6495L7,135@6530L94,146@6850L253:Icon.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(painter) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(contentDescription) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j = tint;
                int i3 = $composer2.changed(j) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                j = tint;
            }
            $dirty |= i3;
        } else {
            j = tint;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            tint3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long jM4197unboximpl = ((Color) objConsume).m4197unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -7169;
                    modifier3 = modifier5;
                    tint2 = Color.m4185copywmQWz5c(jM4197unboximpl, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM4197unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4193getRedimpl(jM4197unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM4197unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM4197unboximpl) : 0.0f);
                } else {
                    tint2 = j;
                    modifier3 = modifier5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                tint2 = j;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1142959010, $dirty, -1, "androidx.compose.material.Icon (Icon.kt:134)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 724359741, "CC(remember):Icon.kt#9igjgp");
            boolean invalid$iv = ((($dirty & 7168) ^ 3072) > 2048 && $composer2.changed(tint2)) || ($dirty & 3072) == 2048;
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = Color.m4188equalsimpl0(tint2, Color.INSTANCE.m4223getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m4228tintxETnrds$default(ColorFilter.INSTANCE, tint2, 0, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            }
            ColorFilter colorFilter2 = (ColorFilter) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (contentDescription != null) {
                $composer2.startReplaceGroup(980462681);
                ComposerKt.sourceInformation($composer2, "139@6706L103");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 724365382, "CC(remember):Icon.kt#9igjgp");
                boolean invalid$iv2 = ($dirty & 112) == 32;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                    colorFilter = colorFilter2;
                    value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.IconKt$Icon$semantics$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                            SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription);
                            SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5959getImageo7Vup1c());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    colorFilter = colorFilter2;
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                companionSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv, 1, null);
                $composer2.endReplaceGroup();
            } else {
                colorFilter = colorFilter2;
                $composer2.startReplaceGroup(980601995);
                $composer2.endReplaceGroup();
                companionSemantics$default = Modifier.INSTANCE;
            }
            Modifier semantics = companionSemantics$default;
            BoxKt.Box(PainterModifierKt.paint(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier3), painter), painter, (22 & 2) != 0, (22 & 4) != 0 ? Alignment.INSTANCE.getCenter() : null, (22 & 8) != 0 ? ContentScale.INSTANCE.getInside() : ContentScale.INSTANCE.getFit(), (22 & 16) != 0 ? 1.0f : 0.0f, (22 & 32) != 0 ? null : colorFilter).then(semantics), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            tint3 = tint2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.IconKt$Icon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) {
                    IconKt.m1586Iconww6aTOc(painter, contentDescription, modifier4, tint3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final Modifier defaultSizeFor(Modifier $this$defaultSizeFor, Painter painter) {
        Modifier.Companion companion;
        if (Size.m4010equalsimpl0(painter.getIntrinsicSize(), Size.INSTANCE.m4022getUnspecifiedNHjbRc()) || m1588isInfiniteuvyYCjk(painter.getIntrinsicSize())) {
            companion = DefaultIconSizeModifier;
        } else {
            companion = Modifier.INSTANCE;
        }
        return $this$defaultSizeFor.then(companion);
    }

    /* renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m1588isInfiniteuvyYCjk(long $this$isInfinite_u2duvyYCjk) {
        return Float.isInfinite(Size.m4014getWidthimpl($this$isInfinite_u2duvyYCjk)) && Float.isInfinite(Size.m4011getHeightimpl($this$isInfinite_u2duvyYCjk));
    }
}
